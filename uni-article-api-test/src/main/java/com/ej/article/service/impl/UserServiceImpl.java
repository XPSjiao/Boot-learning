package com.ej.article.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.ej.article.mapper.UserMapper;
import com.ej.article.model.dto.BindPhoneDto;
import com.ej.article.model.dto.LoginDto;

import com.ej.article.model.dto.WxLoginDto;
import com.ej.article.model.entity.User;
import com.ej.article.service.RedisService;

import com.ej.article.service.UserService;
import com.ej.article.util.AliyunResource;
import com.ej.article.util.FileResource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-22
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private AliyunResource aliyunResource;

    @Resource
    private FileResource fileResource;

    @Override
    public boolean loginByPassword(LoginDto loginDto) {
        User user = getUser((loginDto.getPhone()));
        if (user != null) {
            // 对客户端传递的密码进行加密后，和数据库中的密文比对
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public boolean loginByCode(LoginDto loginDto) {
        //检查redis 中是否存在这个手机号
        boolean flag = redisService.existsKey(loginDto.getPhone());
        if (flag) {
            // 取出redis中之前存储的验证码
            String saveCode = redisService.getValue(loginDto.getPhone(), String.class);
            // 和前端传的验证码比对
            if (saveCode.equalsIgnoreCase(loginDto.getCode())) {
                // 查找数据库该手机号用户是否存在
                User user = getUser(loginDto.getPhone());
                // 不存在就注册为新用户
                if (user == null) {
                    //不存在该手机号,就构建新用户记录，补充必备字段写入数据库，一键注册并登录（密码留空，用户可后期修改）
                    User saveUser = User.builder().phone(loginDto.getPhone()).nickname(loginDto.getPhone()).gender(2).avatar("/static/img/nologin.jpeg").banner("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/banner/banner.jpg").createTime(new Date()).build();
                    userMapper.insert(saveUser);
                }
                //存在就登录成功
                return true;
            }
        }
        return false;
    }

    @Override
    public User updateUser(User user) {
        log.info("用户"+user);
        //先根据手机号查出数据库原用户信息
        User savedUser = getUser(user.getPhone());
        //如果传过来的密码和数据库的密码一样，表示是修改密码；如果传过来的密码是空，表示是微信登录用户首次去修改密码，则需要将密码明文加密
        //对应前端页面为 edit-password
        if (!user.getPassword().equals(savedUser.getPassword()) || user.getPassword() == null) {
            savedUser.setPassword(DigestUtils.md5Hex(user.getPassword()));
        } else {
            //否则就是修改其他信息，密码直接赋原值，以免被覆盖为空 ，对应前端页面为 user-edit
            savedUser.setPassword(user.getPassword());
        }
        // 补全其他信息，banner不修改
        savedUser.setNickname(user.getNickname());
        savedUser.setAvatar(user.getAvatar());
        savedUser.setGender(user.getGender());
        savedUser.setBirthday(user.getBirthday());
        savedUser.setAddress(user.getAddress());
        //更新数据
        userMapper.updateUser(savedUser);
        //将修改后的用户信息返回
        return savedUser;
    }

    @Override
    public User findByOpenId(String wxOpenId) {
        return userMapper.fineUserByOpenId(wxOpenId);
    }


    @Override
    public User wxLogin(WxLoginDto wxLoginDto) {
        User user = findByOpenId(wxLoginDto.getWxOpenId());
        //新用户
        if (user == null) {
            user = User.builder().phone("").wxOpenId(wxLoginDto.getWxOpenId()).nickname(wxLoginDto.getNickname()).avatar(wxLoginDto.getAvatar()).gender(wxLoginDto.getGender()).address("江苏省苏州市").banner("https://soft2176-use.oss-cn-hangzhou.aliyuncs.com/banner/banner1.jpg").createTime(new Date()).build();
            userMapper.insert(user);
        }
        //老用户
        return user;
    }


    @Override
    public String uploadFile(MultipartFile file) {
            // 读入配置文件信息
            String accessKeyId = aliyunResource.getAccessKeyId();
            String accessKeySecret = aliyunResource.getAccessKeySecret();

            String endpoint = fileResource.getEndPoint();
            // 创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String fileName = file.getOriginalFilename();
            // 分割文件名，获得文件后缀名
            assert fileName != null;
            String[] fileNameArr = fileName.split("\\.");
            String suffix = fileNameArr[fileNameArr.length - 1];
            //拼接得到新的上传文件名
            String uploadFileName = fileResource.getObjectName() + UUID.randomUUID() + "." + suffix;
            // 上传网络需要用的字节流
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
            } catch (IOException e) {
                System.err.println("上传文件出现异常");
            }
            //执行阿里云上传文件操作
            ossClient.putObject(fileResource.getBucketName(), uploadFileName, inputStream);
            // 关闭OSSClient
            ossClient.shutdown();
            return uploadFileName;
        }

    @Override
    public User bindPhone(BindPhoneDto bindPhoneDto) {
        // 此时根据手机号查出数据库中用户信息
        User savedUser = userMapper.findUserByPhone(bindPhoneDto.getPhone());
        log.info("1-----" + savedUser);
        // 检查redis中是否有该手机号存储的短信
        boolean flag = redisService.existsKey(bindPhoneDto.getPhone());
        log.info("2------" + flag);
        if (flag) {
            // 取出验证码
            String saveCode = redisService.getValue(bindPhoneDto.getPhone(), String.class);
            //验证码通过
            if (saveCode.equalsIgnoreCase(bindPhoneDto.getCode())) {
                // 该用户对应的wxOpenId如果空，表示还没绑定
                if (savedUser.getWxOpenId() == null || savedUser.getWxOpenId().trim().length() == 0) {
                    // 删除wxOpenId对应的用户记录（合并账号）,要先做这条语句哦，要不然会把主账号也删掉
                    userMapper.deleteUserByOpenId(bindPhoneDto.getWxOpenId());
                    //补全该用户的wxOpenId
                    savedUser.setWxOpenId(bindPhoneDto.getWxOpenId());
                    log.info("3-----" + savedUser);
                    // 更新该手机号对应的记录信息（持久化wxOpenId）
                    userMapper.bandPhone(bindPhoneDto.getPhone(), bindPhoneDto.getWxOpenId());
                    savedUser = userMapper.findUserByPhone(bindPhoneDto.getPhone());
                }
            }
        }
        // 返回用户信息
        return savedUser;
    }
}

