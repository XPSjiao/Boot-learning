package com.ej.boot.orm.service.impl;

import com.ej.boot.orm.dao.ArticleDao;
import com.ej.boot.orm.entity.Article;

import com.ej.boot.orm.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-19
 **/
@Service

public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDao articleDao;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Article saveArticle(Article article) {
        int n = articleDao.save(article);
        if (n != 0){
            return article;
        }else {
            return null;
        }
    }

    @Override
    public List<Article> selectAll() {
        return articleDao.findAll();
    }
}
