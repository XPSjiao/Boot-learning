package com.ej.boot.model;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(SpringExtension.class)//JUnit5的写法
  //@RunWith(SpringRunner.class)  //JUnit4的写法
@SpringBootTest
class EmployeeTest {

    @Resource
    private Employee employee;

    @Test
    void valueBind() throws Exception{
        log.info(String.valueOf(employee));
        Map<String ,Integer> map = employee.getEmployeeAge();

//        Set<Entry<String, Integer>> entries = map.entrySet();
//        for (Entry<String, Integer> entry : entries) {
//            log.info(String.valueOf(entry));
//        }

        map.forEach((key,value) ->System.out.println(key + "->" + value));
    }

    @Test
    public void testList(){
        List<String> list = List.of("bbb", "ccc", "aaa");
//        for (String item : list){
//            System.out.println(item);
//        }
        //list.forEach(str -> System.out.println(str)); 简化为下列代码
        list.forEach(System.out::println);
    }

}