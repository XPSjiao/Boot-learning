package com.ej.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: boot-learning
 * @description: 启动主类
 * @author: EthanJiao
 * @create: 2022-03-15
 **/
@ImportResource(locations = {"classpath:bean.xml","classpath:bean1.xml"})
@SpringBootApplication
@Slf4j
public class BootConfigApplication {
    public static void main(String[] args) {
        //启动主类，看到.class 就要想到反射 args
        SpringApplication.run(BootConfigApplication.class,args);
        log.info("服务启动成功");
    }
}
