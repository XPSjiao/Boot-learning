package com.ej.boot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TestBeanService1Test {
    @Resource
    ConfigurableApplicationContext ioc ;//反射注入

    @Test
    void test(){
        TestBeanService testBeanService = (TestBeanService) ioc.getBean("testBeanService");

        TestBeanService1 testBeanService1 = (TestBeanService1) ioc.getBean("testBeanService1");

        assertEquals("SpringBoot",testBeanService.getName());
        System.out.println(testBeanService.getName());
        assertEquals(30,testBeanService1.getAge());
        System.out.println(testBeanService1.getAge());
    }



}