package com.ej.boot.ormcompleted.service;

import com.ej.boot.ormcompleted.entity.Article;

import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-18
 **/
public interface ArticleService {
    /**
     * 添加文章
     * @param article 入参：文章实体类
     * @return 受影响行数
     */
    int addArticle(Article article);

    /**
     * 按id删除文章
     * @param id 入参：文章id
     * @return  受影响行数
     */
    int deleteArticleById(int id);


    /**
     * 按照id更新文章
     * @param article 入参：文章实体类
     * @return 受影响行数
     */
    int updateArticleById(Article article);


    /**
     * 根据id查找文章
     * @param id 入参：文章id
     * @return 文章实体类
     */
    Article findArticleById(int id);


    /**
     * 查找所有文章
     * @return 所有文章类的list
     */
    List<Article> selectAllArticle();



}
