package com.ej.boot.orm.mapper;

import com.ej.boot.orm.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 焦恒鑫
* @description 针对表【t_teacher】的数据库操作Mapper
* @createDate 2022-03-28 21:01:02
* @Entity generator.domain.Teacher
*/
@Mapper
public interface TeacherMapper {
    Teacher findOneByOne(Integer id);
}




