package com.ej.boot.orm.mapper;

import com.ej.boot.orm.domain.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@ExtendWith({SpringExtension.class})
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = new Student();
        student.setBirthday(new Date());
        student.setClazzId(1);
        student.setHometown("测试");
        student.setStudentName("测试");
        studentMapper.insert(student);
    }

    @Test
    void findManyByOne() {
        Student student = studentMapper.findManyByOne(1001);
        log.info("学生信息：" + student.getStudentId() + " " + student.getStudentName() + " " + student.getHometown() + " " + student.getBirthday());
        log.info("学生所在信息：" + student.getClazz().getClazzId() + "   " + student.getClazz().getClazzName());
    }

    @Test
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info(String.valueOf(student));
    }

    @Test
    void batchInsert() {
        long begin = System.currentTimeMillis();
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Student student = new Student();
            student.setClazzId(1);
            student.setStudentName("测试学生" + i);
            student.setHometown("江苏南京");
            student.setBirthday(new Date());
            students.add(student);
        }
        int count = studentMapper.batchInsert(students);
        log.info(String.valueOf(count));
        long end = System.currentTimeMillis();
        long period = end - begin;
        System.out.println(period);
    }

    @Test
    void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student student = new Student();
            student.setStudentId(1001 + i);
            student.setStudentName("111");
            students.add(student);
        }
        studentMapper.batchUpdate(students);
    }

    @Test
    void findBy() {
        Student student = new Student();
        student.setHometown("州");
        List<Student> students = studentMapper.findStudentBy(student);
        log.info(String.valueOf(students.size()));
        students.forEach(stu -> log.info(String.valueOf(stu)));
    }

    @Test
    void testPage() {
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法回被分页！
        PageHelper.startPage(1, 2);
        //动态查询参数为空，默认为查所有数据
        List<Student> students = studentMapper.findStudentBy(new Student());
        PageInfo<Student> page = PageInfo.of(students);
        log.info(String.valueOf(page));
    }


}