package com.ej.article.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-26
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BindPhoneDto {
    private String phone;
    private String code;
    private String wxOpenId;
}
