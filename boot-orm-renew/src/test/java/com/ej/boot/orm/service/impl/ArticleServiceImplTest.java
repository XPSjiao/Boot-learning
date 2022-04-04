package com.ej.boot.orm.service.impl;

import com.ej.boot.orm.dao.ArticleDao;
import com.ej.boot.orm.entity.Article;

import com.ej.boot.orm.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleServiceImplTest {

    @Resource
    private ArticleService articleService;
    @Test
    void saveArticle() {
        Article article = Article.builder()
                .id(1010)
                .author("EthanJiao")
                .title("java")
                .content("java从入门到入土")
                .build();
        Article saveArticle = articleService.saveArticle(article);
        assertNotNull(saveArticle);

    }
}