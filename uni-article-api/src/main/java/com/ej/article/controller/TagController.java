package com.ej.article.controller;

import com.ej.article.service.TagService;
import com.ej.article.model.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 21:40
 **/
@RestController
@RequestMapping(value = "/api/v1/tags")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("all")
    public List<Tag> getTags() {
        return tagService.selectAll();
    }
}