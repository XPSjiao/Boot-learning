package com.ej.article.service.impl;

import com.ej.article.service.TagService;
import com.ej.article.mapper.TagMapper;
import com.ej.article.model.entity.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 21:30
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }
}