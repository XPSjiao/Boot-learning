package com.ej.article.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ej.article.service.RedisService;
import com.ej.article.service.UserService;
import com.ej.article.mapper.UserMapper;
import com.ej.article.model.dto.BindPhoneDto;
import com.ej.article.model.dto.LoginDto;
import com.ej.article.model.dto.WxLoginDto;
import com.ej.article.model.entity.User;
import com.ej.article.util.AliyunResource;
import com.ej.article.util.FileResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-22 17:29
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private FileResource fileResource;
    @Resource
    private AliyunResource aliyunResource;

    @Override
    public boolean passwordLogin(LoginDto loginDto) {
        User user = getUser(loginDto.getPhone());
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public boolean verifyCodeLogin(LoginDto loginDto) {
        //判断redis中是否存在对应的key
        boolean flag = redisService.existsKey(loginDto.getPhone());
        if (flag) {
            String code = redisService.getValue(loginDto.getPhone(), String.class);
            if (code.equalsIgnoreCase(loginDto.getCode())) {
                User user = userMapper.findUserByPhone(loginDto.getPhone());
                if (user == null) {
                    user = User.builder().phone(loginDto.getPhone())
                            .nickname("新用户")
                            .banner("https://cdn.jsdelivr.net/gh/yy123/image-hosting@master/pag3.1ao7erlnhbcw.jpg")
                            .avatar("https://cdn.jsdelivr.net/gh/yy123/image-hosting@master/user-avatar-fill.700e2vn53rc0.webp").createTime(new Date()).build();
                    userMapper.insert(user);
                }
                return true;
            }
        }
        return false;
    }


    @Override
    public User findByOpenId(String wxOpenId) {
        return userMapper.findUserByOpenId(wxOpenId);
    }

    @Override
    public User wxLogin(WxLoginDto wxLoginDto) {
        User user = findByOpenId(wxLoginDto.getWxOpenId());
        if (user == null) {
            user = User.builder()
                    .wxOpenId(wxLoginDto.getWxOpenId())
                    .gender(wxLoginDto.getGender())
                    .nickname(wxLoginDto.getNickname())
                    .banner("https://cdn.jsdelivr.net/gh/yy123/image-hosting@master/pag3.1ao7erlnhbcw.jpg")
                    .address("江苏南京")
                    .avatar(wxLoginDto.getAvatar()).createTime(new Date()).build();
            userMapper.insert(user);

        }
        log.info("user"+user);
        return user;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        //    读入配置文件
        String endpoint = fileResource.getEndPoint();
        String accessKeyId = aliyunResource.getAccessKeyId();
        String accessKeySecret = aliyunResource.getAccessKeySecret();
        //    创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName = file.getOriginalFilename();
        //    分割文件名，获得文件后缀名
        assert fileName != null;
        String[] fileNameArr = fileName.split("\\.");
        String suffix = fileNameArr[fileNameArr.length - 1];
        //    拼接得到新的上传文件名
        String uploadFileName = fileResource.getObjectName() + UUID.randomUUID() + "." + suffix;
        //   上传网络需要用的字节流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            System.err.println("上传文件出现异常");
        }
        //    执行阿里云上传文件操作
        ossClient.putObject(fileResource.getBucketName(), uploadFileName, inputStream);
        //    关闭OSSClient
        ossClient.shutdown();
        return uploadFileName;
    }

    @Override
    public User updateUser(User user) {
        //先根据手机号查出数据库用户信息
        User saveUser = getUser(user.getPhone());
        //如果是修改密码的请求，将密码加密
        if (!user.getPassword().equals(saveUser.getPassword())) {
            saveUser.setPassword(DigestUtils.md5Hex(user.getPassword()));
        } else {
            saveUser.setPassword(user.getPassword());
        }
        saveUser.setNickname(user.getNickname());
        saveUser.setAvatar(user.getAvatar());
        saveUser.setGender(user.getGender());
        saveUser.setBirthday(user.getBirthday());
        saveUser.setAddress(user.getAddress());
        saveUser.setBanner(user.getBanner());
        //更新数据
        userMapper.update(saveUser);
        //将修改后的用户信息返回
        return saveUser;
    }

    @Override
    public User bindPhone(BindPhoneDto bindPhoneDto) {
        User savedUser = new User();
        // 检查redis中是否有该手机号存储的短信
        boolean flag = redisService.existsKey(bindPhoneDto.getPhone());
        if (flag) {
            // 取出验证码
            String saveCode = redisService.getValue(bindPhoneDto.getPhone(), String.class);
            //验证码通过
            if (saveCode.equalsIgnoreCase(bindPhoneDto.getCode())) {
                // 此时根据手机号查出数据库中用户信息
                savedUser = userMapper.findUserByPhone(bindPhoneDto.getPhone());
                if (savedUser != null) {
                    // 该用户对应的wxOpenId如果空，表示还没绑定
                    if (savedUser.getWxOpenId() == null || savedUser.getWxOpenId().trim().length() == 0) {
                        // 删除wxOpenId对应的用户记录（合并账号）,要先做这条语句哦，要不然会把主账号也删掉
                        userMapper.deleteUserByOpenId(bindPhoneDto.getWxOpenId());
                        //补全该用户的wxOpenId
                        savedUser.setWxOpenId(bindPhoneDto.getWxOpenId());
                        // 更新该手机号对应的记录信息（持久化wxOpenId）
                        userMapper.bandWx(bindPhoneDto.getWxOpenId(), bindPhoneDto.getPhone());
                        savedUser = userMapper.findUserByPhone(bindPhoneDto.getPhone());
                    }
                } else {
                    savedUser = userMapper.findUserByOpenId(bindPhoneDto.getWxOpenId());
                    savedUser.setPhone(bindPhoneDto.getPhone());
                    userMapper.bandPhone(bindPhoneDto.getWxOpenId(), bindPhoneDto.getPhone());
                }
            }
        }
        // 返回用户信息
        log.info("savedUser"+savedUser);
        return savedUser;
    }
}