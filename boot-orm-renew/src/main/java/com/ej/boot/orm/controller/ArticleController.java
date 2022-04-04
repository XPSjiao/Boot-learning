package com.ej.boot.orm.controller;

import com.ej.boot.orm.entity.Article;

import com.ej.boot.orm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-19
 **/
@RestController
@RequestMapping(value = "/api/v1/articles")
public class ArticleController {


    private final ArticleService  articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(value = "/all")
    public List<Article> selectAll(){
        return articleService.selectAll();
    }

    @PostMapping()
    public Article addArticle(@RequestBody Article article){
        return articleService.saveArticle(article);
    }
}
