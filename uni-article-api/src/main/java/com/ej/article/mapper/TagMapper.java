package com.ej.article.mapper;

import com.ej.article.model.entity.Tag;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {
    /**
     * 批量插入tag
     *
     * @param tagList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int batchInsert(@Param(value = "tagList") List<Tag> tagList);

    /**
     * 查询所有标签
     *
     * @return
     */
    @Select("SELECT  * FROM t_tag")
    List<Tag> selectAll();

    /**
     * 根据文章id查询所有标签
     *
     * @param articleId
     * @return
     */
    @Select("SELECT  a.id,a.tag_name FROM t_tag a LEFT JOIN t_article_tag b ON a.id = b.tag_id LEFT JOIN t_article c" +
            " ON b.article_id = c.id WHERE c.id = #{articleId}")
    List<Tag> selectByArticleId(@Param("articleId") int articleId);
}
