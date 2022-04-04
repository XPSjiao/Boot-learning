package com.ej.boot.orm.dozer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-03-28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo {
    private Integer id;
    private String phone;
    private String avatar;
    private List<Book> books;
}
