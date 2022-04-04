package com.ej.boot.ormcompleted.service;

import com.ej.boot.ormcompleted.entity.Article;

import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-18
 **/

public interface ArticleJpaService {
    /**
     * 根据作者查文章
     * @param author 入参：作者
     * @return 作者的文章列表
     */
    List<Article> findArticleByAuthor(String author);
}

