package com.ej.article.mapper;

import com.ej.article.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleTagMapper {
    /**
     * 批量插入
     *
     * @param articleTagList
     */
    void batchInsert(@Param(value = "articleTagList") List<ArticleTag> articleTagList);

    /**
     * 查询指定文章的所有标签
     *
     * @param articleId
     * @return
     */
    @Select("SELECT * FROM t_article_tag WHERE article_id = #{articleId}")
    List<ArticleTag> selectByArticleId(@Param(value = "articleId") String articleId);
}
