package com.ej.article.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 20:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleTag {
    private Integer id;
    private Integer articleId;
    private Integer tagId;
    private String tagName;
}