package com.ej.article.service.impl;

import com.ej.article.mapper.CommentMapper;
import com.ej.article.model.entity.Comment;
import com.ej.article.service.CommentService;
import com.ej.article.model.vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 21:33
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<CommentVo> selectByArticleId(int articleId) {

        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public List<CommentVo> addComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        commentMapper.addComment(comment);
        return commentMapper.selectByArticleId(comment.getArticleId());
    }
}