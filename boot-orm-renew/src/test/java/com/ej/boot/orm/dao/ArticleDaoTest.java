package com.ej.boot.orm.dao;

import com.ej.boot.orm.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleDaoTest {
    @Resource
    private ArticleDao articleDao;

    @Test
    void save() {
        Article article = Article.builder()
                .id(4)
                .author("jhx")
                .title("Java从入门到放弃 ")
                .content("SpringBoot从入门到放弃")
                .build();
        int rows = articleDao.save(article);
        assertEquals(1,rows);
        System.out.println(rows);
    }

    @Test
    void deleteById() {

        int rows = articleDao.deleteById(7);
        assertEquals(1,rows);
    }

    @Test
    void updateById() {
        Article article = Article.builder()
                .id(5)
                .author("jhx")
                .title("Java从入门到放弃 ")
                .content("Java从入门到放弃")
                .createTime(new Date())
                .build();
        int rows = articleDao.updateById(article);
        assertEquals(1,rows);

    }

    @Test
    void findById() {
        Article article = articleDao.findById(5);
        log.info(article.toString());
    }

    @Test
    void findAll() {
        List<Article> articles = articleDao.findAll();
        articles.forEach(article -> log.info(article.toString()));
    }
}