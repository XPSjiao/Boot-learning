package com.ej.article.mapper;


import com.github.pagehelper.Page;
import com.ej.article.model.entity.Article;
import com.ej.article.model.vo.ArticleVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ej
 * @description 针对表【t_article】的数据库操作Mapper
 * @createDate 2022-03-28 15:53:53
 * @Entity com.yy.article.model.entity.Article
 */

public interface ArticleMapper {
    /**
     * 插入文章
     *
     * @param article
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO t_article (category,user_id,title,cover,summary,content,create_time) " +
            "VALUES(#{article.category},#{article.userId},#{article.title}," +
            "#{article.cover},#{article.summary},#{article.content},#{article.createTime})")
    void insertArticle(@Param("article") Article article);

    /**
     * 批量插入
     *
     * @param articleList
     * @return
     */
    int batchInsert(@Param(value = "articleList") List<Article> articleList);

    /**
     * 分页查询所有文章
     *
     * @return
     */
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.user_id = b.id ORDER BY a.create_time DESC")
    Page<ArticleVo> selectAll();


    /**
     * 根据id查询文章详情
     *
     * @param id
     * @return
     */
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.user_id = b.id WHERE a.id =#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "tagList", column = "id",
                    many = @Many(
                            select = "com.ej.article.mapper.ArticleTagMapper.selectByArticleId"
                    )),
            @Result(property = "commentList", column = "id", many = @Many(
                    select = "com.ej.article.mapper.CommentMapper.selectByArticleId"
            ))
    })
    ArticleVo getDetail(@Param(value = "id") int id);
}




