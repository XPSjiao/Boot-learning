package com.ej.boot.model;

import com.ej.boot.util.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @program: boot-learning
 * @description: 用户类
 * @author: EthanJiao
 * @create: 2022-03-14
 **/
//@Data
//@Component
//@ConfigurationProperties(prefix = "user")
//@PropertySource(value = {"classpath=user.yml"},factory = MixPropertySourceFactory.class)
//@Validated
public class User {
    private String name;
    private Book book;
}
