package com.ej.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-learning
 * @description: HelloController
 * @author: EthanJiao
 * @create: 2022-03-07
 **/
@RestController

public class HelloController {

    @GetMapping(value = "/hello")
    public String Hello(){
        return "hello world";
    }
}
