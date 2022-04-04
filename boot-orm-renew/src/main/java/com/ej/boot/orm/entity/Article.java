package com.ej.boot.orm.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.AliasFor;

import java.util.Date;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;
    private Date createTime;
}
