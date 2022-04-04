package com.ej.article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: boot-learning
 * @description: 启动类
 * @author: EthanJiao
 * @create: 2022-03-22
 **/
@SpringBootApplication
@MapperScan("com.ej.article.mapper")
public class UniArticleApiApplication {
    public static void main(String[] args) {
      SpringApplication.run(UniArticleApiApplication.class,args);
    }
}
