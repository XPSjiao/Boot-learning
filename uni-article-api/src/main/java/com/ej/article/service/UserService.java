package com.ej.article.service;

import com.ej.article.model.dto.BindPhoneDto;
import com.ej.article.model.dto.LoginDto;
import com.ej.article.model.dto.WxLoginDto;
import com.ej.article.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-22 17:27
 **/
public interface UserService {
    /**
     * 登录
     *
     * @param loginDto
     * @return
     */
    boolean passwordLogin(LoginDto loginDto);

    /**
     * 根据手机号查找用户
     *
     * @param phone
     * @return
     */
    User getUser(String phone);

    /**
     * 验证码登录
     * @param loginDto
     * @return
     */
    boolean verifyCodeLogin(LoginDto loginDto);


    /**
     * 根据openid查找用户
     * @param wxOpenId
     * @return
     */
    User findByOpenId(String wxOpenId);

    /**
     * 微信登录
     * @param wxLoginDto
     * @return
     */
    User wxLogin(WxLoginDto wxLoginDto);

    /**
     * 文件上传到OSS
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    User updateUser(User user);

    User bindPhone(BindPhoneDto bindPhoneDto);
}