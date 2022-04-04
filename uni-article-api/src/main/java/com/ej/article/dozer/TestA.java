package com.ej.article.dozer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-28 10:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestA {
    private String name;
    private String createDate;
}