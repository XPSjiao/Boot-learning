package com.ej.article.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 15:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Integer id;
    private Integer articleId;
    private Integer userId;
    private String content;
    private LocalDateTime createTime;
}