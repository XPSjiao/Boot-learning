package com.ej.boot.orm.dao;

import com.ej.boot.orm.entity.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-19
 **/
@Repository
public class ArticleDao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    /**
     * 新增文章
     *
     * @param article
     * @return
     */
    public int save(Article article) {
        String sql = "INSERT INTO article (author,title,content) VALUES (?,?,?) ";
        return jdbcTemplate.update(sql,
                article.getAuthor(),
                article.getTitle(),
                article.getContent());
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM article WHERE id = ? " , id );
    }


    /**
     * 更新文章
     * @param article
     * @return
     */
    public int updateById(Article article) {
        String sql = "UPDATE  article SET author = ? , title = ? , content = ? , create_time = ? WHERE id = ?  ";
        return jdbcTemplate.update(sql,
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId()
        );
    }


    /**
     * 查找文章
     * @param id
     * @return
     */
    public Article findById(int id){
        String sql = "SELECT * FROM article WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql ,new BeanPropertyRowMapper<>(Article.class), id);
    }

    public List<Article> findAll(){
        String sql = "SELECT * FROM article ";
        return jdbcTemplate.query(sql , new BeanPropertyRowMapper<>(Article.class));
    }
}
