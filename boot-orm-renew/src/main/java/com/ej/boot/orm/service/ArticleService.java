package com.ej.boot.orm.service;

import com.ej.boot.orm.entity.Article;

import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-19
 **/
public interface ArticleService {
    /**
     * 新增文章
     * @param article
     * @return
     */
    Article saveArticle(Article article);

    List<Article> selectAll();

}
