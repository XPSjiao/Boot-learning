package com.ej.boot.model;

import lombok.Data;

import java.util.Date;

/**
 * @program: boot-learning
 * @description: 书类
 * @author: EthanJiao
 * @create: 2022-03-14
 **/
@Data
public class Book {
    private String bookName;
    private Integer price;
    private Date date;


}
