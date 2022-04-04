package com.ej.boot.orm.mapper;

import com.ej.boot.orm.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
* @author 焦恒鑫
* @description 针对表【t_student】的数据库操作Mapper
* @createDate 2022-03-28 21:01:02
* @Entity generator.domain.Student
*/
@Mapper
@Alias("studentMap")
public interface StudentMapper {

    /**
     * 根据学生id查询学生班级信息
     * @param studentId
     * @return
     */
    Student findManyByOne(int studentId);

    /**
     * 根据学生id查询学生
     * @param studentId
     * @return
     */
    Student getStudent(int studentId);

    /**
     * 新增
     * @param student
     * @return
     */
    int insert(Student student);

    /**
     * 批量新增
     * @param students
     * @return
     */

    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     * @param ids
     * @return
     */

    int batchDelete(@Param("ids")List<Integer> ids);

    /**
     * 批量修改
     * @param students
     * @return
     */

    int batchUpdate(@Param("students")List<Student> students);

    /**
     * 动态查询
     * @param student
     * @return
     */

    List<Student> findStudentBy(@Param("student")Student student);
}




