package com.ej.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TestBeanServiceTest {
    //注入Spring上下文环境
    @Resource
    private ConfigurableApplicationContext ioc;

    @Test
    void testLoadService(){
        //从测试环境的Spring上下文环境中读取xml配置文件，得到testBeanService,有的话xml配置就生效
//        boolean flag = ioc.containsBean("testBeanService");
//       assertTrue(flag);
       TestBeanService  tbs = (TestBeanService) ioc.getBean("testBeanService");
       log.info(tbs.getName());
       assertEquals("SpringBoot",tbs.getName()); //断言
    }

}