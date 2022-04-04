package com.ej.article.mapper;

import com.ej.article.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

//    @Test
//    void insert() throws  Exception{
//        User user = User.builder()
//                .phone("13328089790")
//                .password("4297f44b13955235245b2497399d7a93")
//                .nickname("豆豆")
//                .avatar("https://img2.woyaogexing.com/2022/03/21/ef86e3d2f3f742cba40e8bdd703d55f5!400x400.jpeg")
//                .gender(0)
//                .birthday(LocalDate.now())
//                .address("江苏南通")
//                .createTime(new Date())
//                .build();
//        userMapper.insert(user);
//    }

    @Test
    void insert() throws  Exception{
        User user = User.builder()
                .phone("18012275669")
                .password("4297f44b13955235245b2497399d7a93")
                .nickname("笑笑")
                .avatar("http://img.duoziwang.com/2021/01/1-2104101544430-L.jpg")
                .gender(1)
                .birthday(LocalDate.now())
                .address("江苏苏州")
                .createTime(new Date())
                .build();
        userMapper.insert(user);
    }
    @Test
    void findUserByPhone() {
        User user = userMapper.findUserByPhone("18012275669");
        assertNotNull(user);
        log.info(String.valueOf(user));
    }
}