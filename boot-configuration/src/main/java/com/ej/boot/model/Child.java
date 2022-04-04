package com.ej.boot.model;

import lombok.Data;

import java.util.List;

/**
 * @program: boot-learning
 * @description: 每个child 有 name、age 属性 和 一个 friends属性集合
 * @author: EthanJiao
 * @create: 2022-03-15
 **/
@Data
public class Child {
    private String name ;
    private Integer age;
    private List<Friend> friends;

}
