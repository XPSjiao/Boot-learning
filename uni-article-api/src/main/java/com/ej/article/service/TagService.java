package com.ej.article.service;

import com.ej.article.model.entity.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询所有标签
     * @return
     */
    List<Tag> selectAll();
}
