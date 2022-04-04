package com.ej.article.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: uni-article-api
 * @description:
 * @author: ej
 * @create: 2022-03-25 12:53
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WxLoginDto {
    private String wxOpenId;
    private String nickname;
    private Integer gender;
    private String avatar;
}