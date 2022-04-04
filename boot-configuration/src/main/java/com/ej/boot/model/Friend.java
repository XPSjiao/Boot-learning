package com.ej.boot.model;

import lombok.Data;

/**
 * @program: boot-learning
 * @description: 朋友 每个friend有两个属性，分别是 hobby和gender
 * @author: EthanJiao
 * @create: 2022-03-15
 **/
@Data
//get、set方法注解
public class Friend {
    private String hobby;
    private String gender;
}
