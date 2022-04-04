package com.ej.article.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @program: uni-article-api
 * @description:
 * @author: ej
 * @create: 2022-03-29 18:55
 **/
@Data
@Builder
public class AddArticleDto {
    private Integer userId;
    private String title;
    private String content;
    private String summary;
    private String cover;
    private String category;
    private Date createTime;
}