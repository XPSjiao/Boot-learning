package com.ej.boot.model;



import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @program: boot-learning
 * @description: 数据库加密测试类
 * @author: EthanJiao
 * @create: 2022-03-16
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseTest {
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void getPass() {
        String url = encryptor.encrypt("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("123456");
        System.out.println("database url: " + url);
        System.out.println("database name: " + name);
        System.out.println("database password: " + password);
        assertTrue(url.length() > 0);
        assertTrue(name.length() > 0);
        assertTrue(password.length() > 0);
    }
}
