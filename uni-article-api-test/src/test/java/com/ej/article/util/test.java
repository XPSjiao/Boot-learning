package com.ej.article.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-25
 **/
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class test {

    @Resource
    private AliyunResource aliyunResource;
    @Test
    void test01(){
        System.out.println(aliyunResource.getSignName());

    }
}
