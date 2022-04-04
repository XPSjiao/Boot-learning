package com.ej.boot.orm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-29
 **/
@RestController
@RequestMapping
public class test {
    @GetMapping("test")
    String test() {
        return "123123";
    }
}
