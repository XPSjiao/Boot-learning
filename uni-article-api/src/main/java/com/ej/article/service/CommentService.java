package com.ej.article.service;

import com.ej.article.model.entity.Comment;
import com.ej.article.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    List<CommentVo> selectByArticleId(int articleId);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    List<CommentVo> addComment(@Param("comment") Comment comment);
}
