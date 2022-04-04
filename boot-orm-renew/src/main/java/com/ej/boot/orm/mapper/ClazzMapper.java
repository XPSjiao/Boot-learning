package com.ej.boot.orm.mapper;

import com.ej.boot.orm.domain.Clazz;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 焦恒鑫
* @description 针对表【t_clazz】的数据库操作Mapper
* @createDate 2022-03-28 21:01:02
* @Entity generator.domain.Clazz
*/
@Mapper
public interface ClazzMapper {

    /**
     * 根据班级id查询班级信息
     * @param clazzId
     * @return
     */
    Clazz findOneByMany(int clazzId);


    /**
     * 根据班级id查询班级信息
     * @param clazzId
     * @return
     */
    Clazz getClazz(int clazzId);

}




