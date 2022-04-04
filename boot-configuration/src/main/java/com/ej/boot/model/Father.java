package com.ej.boot.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

/**
 * @program: boot-learning
 * @description: 爸爸有两个属性，姓名和年龄
 * @author: EthanJiao
 * @create: 2022-03-15
 **/
@Data
public class Father {
    private String name;

    @Min(value = 22 ,message = "爸爸的年龄不能小于22岁！！")
    private Integer age;

    @Email
    private String email;
}
