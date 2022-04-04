package com.ej.article.controller;

import com.ej.article.service.CommentService;
import com.ej.article.common.ResponseResult;
import com.ej.article.model.entity.Comment;
import com.ej.article.model.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 21:42
 **/
@RestController
@RequestMapping(value = "/api/v1/comments")
@Slf4j
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("{id}")
    public ResponseResult selectByArticleId(@PathVariable int id) {
        List<CommentVo> commentVoList = commentService.selectByArticleId(id);
        return ResponseResult.success(commentVoList);
    }

    @PostMapping("add")
    public ResponseResult addComment(@RequestBody Comment comment) {
        List<CommentVo> commentVoList = commentService.addComment(comment);
        return ResponseResult.success(commentVoList);
    }
}