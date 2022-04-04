package com.ej.article.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-30 15:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Alias("CommentVo")
public class CommentVo {
    private Integer id;
    private String articleId;
    private Integer userId;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;
    private String nickname;
    private String avatar;
}