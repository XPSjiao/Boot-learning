package com.ej.article.controller;

import com.ej.article.common.ResponseResult;
import com.ej.article.model.entity.Article;
import com.ej.article.model.vo.ArticleVo;
import com.ej.article.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-29 16:44
 **/
@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("page")
    public ResponseResult getArtcleByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                                          @RequestParam(name = "pageSize", defaultValue = "6", required = false) int pageSize) {

        return ResponseResult.success(articleService.selectByPage(pageNum, pageSize));
    }

    @GetMapping("{id}")
    public ResponseResult getArticleDetail(@PathVariable int id) {
        ArticleVo detail = articleService.getDetail(id);
        return ResponseResult.success(detail);
    }

    @PostMapping("post")
    public ResponseResult postArticle(@RequestBody Article article) {
        return ResponseResult.success(articleService.postArticle(article));
    }


}