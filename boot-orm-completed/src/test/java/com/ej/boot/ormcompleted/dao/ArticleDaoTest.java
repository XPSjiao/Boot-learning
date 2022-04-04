package com.ej.boot.ormcompleted.dao;

import com.ej.boot.ormcompleted.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ArticleDaoTest {


    @Resource
    ArticleDao articleDao;

    @Test
    void save() {
        int result = articleDao.save(Article.builder()
                .author("jhx")
                .content("mybatis入门到入土")
                .title("mybatis")
                .thumbnail("1")
                .createTime(new Date())
                .build());
        assertEquals(10, result);
    }

    @Test
    void deleteById() {
        int i = articleDao.deleteById(2);
        assertEquals(1, i);
    }

    @Test
    void updateById() {
        int i = articleDao.updateById(Article.builder()
                .id(1)
                .author("jhx")
                .title("springboot")
                .thumbnail("1")
                .content("我放弃了")
                .createTime(new Date())
                .build());
        assertEquals(1, i);
    }

    @Test
    void findById() {
        Article article = articleDao.findById(1);
        log.info(article.toString());
    }

    @Test
    void selectAll() {
        List<Article> articles = articleDao.selectAll();
        articles.forEach(article -> log.info(article.toString()));
    }
}