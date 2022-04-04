package com.ej.article.service.impl;

import com.ej.article.mapper.ArticleMapper;
import com.ej.article.mapper.ArticleTagMapper;
import com.ej.article.mapper.TagMapper;
import com.ej.article.model.entity.Article;
import com.ej.article.model.entity.ArticleTag;
import com.ej.article.model.entity.Tag;
import com.ej.article.service.ArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ej.article.model.vo.ArticleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-29 16:40
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Resource
    private TagMapper tagMapper;

    @Override
    public void insertArticles(List<Article> articles) {
        articleMapper.batchInsert(articles);
        assert articles != null;
        articles.forEach(article -> {
            if (article.getTagList() != null) {
                articleTagMapper.batchInsert(article.getTagList());
            }
        });
    }

    @Override
    public List<ArticleVo> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<ArticleVo> articleVoPage = articleMapper.selectAll();
        List<ArticleVo> result = articleVoPage.getResult();
        result.forEach(articleVo -> {
            List<Tag> tags = tagMapper.selectByArticleId(Integer.parseInt(articleVo.getId()));
            articleVo.setTagList(tags);
        });

        PageInfo<ArticleVo> articleVoPageInfo =  new PageInfo<>(articleVoPage);
        return articleVoPageInfo.getList();
    }

    @Override
    public ArticleVo getDetail(int id) {
        return articleMapper.getDetail(id);
    }

    @Override
    public Article postArticle(Article article) {
        article.setCover("https://i.picsum.photos/id/1038/1920/1080?random&rand=" + Math.random());
        article.setCreateTime(LocalDateTime.now());
        articleMapper.insertArticle(article);
        List<ArticleTag> tagList = article.getTagList();
        tagList.forEach(tag -> tag.setArticleId(article.getId()));
        articleTagMapper.batchInsert(tagList);
        return article;
    }
}