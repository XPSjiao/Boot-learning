package com.ej.boot.ormcompleted.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: boot-learning
 * @description: 文章实体类
 * @author: EthanJiao
 * @create: 2022-03-18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private String thumbnail;

    private String content;

    @Column(name = "create_time",updatable = false)
    private Date createTime;

    private Date updateTime;
}

