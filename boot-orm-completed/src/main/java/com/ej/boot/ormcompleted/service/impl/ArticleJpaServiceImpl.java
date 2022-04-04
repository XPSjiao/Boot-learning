package com.ej.boot.ormcompleted.service.impl;

import com.ej.boot.ormcompleted.dao.ArticleRepository;
import com.ej.boot.ormcompleted.entity.Article;
import com.ej.boot.ormcompleted.service.ArticleJpaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-18
 **/
@Service
public class ArticleJpaServiceImpl implements ArticleJpaService {

    @Resource
    private ArticleRepository articleRepository;


    @Override
    public List<Article> findArticleByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }
}
