package com.ej.boot.ormcompleted.service.impl;

import com.ej.boot.ormcompleted.dao.ArticleDao;
import com.ej.boot.ormcompleted.entity.Article;
import com.ej.boot.ormcompleted.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-18
 **/

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleDao articleDao;


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int addArticle(Article article) {
        return articleDao.save(article);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int deleteArticleById(int id) {
        return articleDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int updateArticleById(Article article) {
        return articleDao.updateById(article);
    }

    @Override
    public Article findArticleById(int id) {
        return articleDao.findById(id);
    }

    @Override
    public List<Article> selectAllArticle() {
        return articleDao.selectAll();
    }

}
