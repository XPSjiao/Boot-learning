package com.ej.article.mapper;

import com.ej.article.common.Gender;
import com.ej.article.mapper.UserMapper;
import com.ej.article.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;


    @Test
    public void addUser() {
        User user = User.builder()
                .nickname("微信用户")
                .wxOpenId("111111111111111")
                .address("江苏南京")
                .createTime(new Date())
                .avatar("https://cdn.jsdelivr.net/gh/yy123/image-hosting@master/me.583hffnfvkw0.png")
                .gender(1)
                .banner("https://cdn.jsdelivr.net/gh/yy123/image-hosting@master/xxzl.5gkix7c0skw0.jpg")
                .build();
        userMapper.insert(user);
    }

    @Test
    void findUserByPhone() {
        User user = userMapper.findUserByPhone("13913457284");
        log.info(String.valueOf(user));
    }



    @Test
    public void updateUser(){
        User user = userMapper.findUserByPhone("13913457284");
        user.setAddress("江苏徐州");
        user.setGender(Gender.FEMALE.getKey());
        user.setNickname("盏茶作酒");
        user.setPassword(DigestUtils.md5Hex("123456"));
        userMapper.update(user);

    }

}