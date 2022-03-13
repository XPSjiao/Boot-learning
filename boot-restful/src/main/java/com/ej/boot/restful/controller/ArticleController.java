package com.ej.boot.restful.controller;

import com.ej.boot.restful.model.Article;
import com.ej.boot.restful.common.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-10
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ArticleController {

    /**
     * 获取一篇Article，使用GET方法,根据id查询一篇文章
     *
     * @param id id
     * @return AjaxResponse
     */
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article = Article.builder().id(id).author("EthanJiao").content("SpringBoot 变大变强").title("SpringBoot").createTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    /**
     * 增加一篇Article ，使用POST方法(RequestBody方式接收参数)
     *
     * @param article article
     * @param aaa     aaa
     * @return AjaxResponse
     */
//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(@RequestBody Article article, @RequestHeader String aaa) {
//        log.info("saveArticle:" + article);
//        log.info("请求头aaa:" + aaa);
//        return AjaxResponse.success(article);
//    }

    /**
     * 增加一篇Article ，使用POST方法(RequestParam方式接收参数
     *
     * @param author     author
     * @param title      title
     * @param content    content
     * @param createTime createTime
     * @return AjaxResponse
     */
    @PostMapping("/articles")
    public AjaxResponse saveArticle(@RequestParam String author, @RequestParam String title, @RequestParam String content, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam Date createTime) {
        log.info("saveArticle:" + author);
        log.info("saveArticle:" + title);
        log.info("saveArticle:" + content);
        log.info("saveArticle:" + createTime);
        return AjaxResponse.success();
    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param article article
     * @return AjaxResponse
     */
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            log.error("没有id");
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id id
     * @return AjaxResponse
     */
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
}