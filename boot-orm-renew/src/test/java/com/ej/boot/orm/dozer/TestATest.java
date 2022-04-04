package com.ej.boot.orm.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestATest {

    @Test
    void  beanCopyTest(){
        User user = User.builder().id(1).phone("18012275669").password("123123").avatar("1.jpg").createTime(new Date()).build();
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setPhone(user.getPhone());
        userVo.setAvatar(user.getAvatar());
        log.info(String.valueOf(userVo));

    }

    @Test
    void  beanUtilsTest(){
        User user = User.builder().id(1).phone("18012275669").password("123123").avatar("1.jpg").createTime(new Date()).build();

        UserVo userVo = new UserVo();
        //是Spring的BeanUtils，不是apache的
        BeanUtils.copyProperties(user,userVo);
        log.info(String.valueOf(userVo));
    }
    @Test
    void  dozerTest1(){
        User user = User.builder().id(1).phone("18012275669").password("123123").avatar("1.jpg").createTime(new Date()).build();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        UserVo userVo = mapper.map(user,UserVo.class);
        log.info(String.valueOf(userVo));
    }



    @Test
    void dozerTest2(){
        TestA testA = new TestA("xiaoxiao","2022-03-28 12:12:12");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        TestB testB = mapper.map(testA,TestB.class);
        log.info(String.valueOf(testB));
    }

    @Test
    void dozerTest3(){
        Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles("dozer/dozer-mapping.xml").build();
        TestA testA = new TestA("xiaoxiao","2022-03-28 12:12:12");
        TestB testB = mapper.map(testA,TestB.class);
        log.info(String.valueOf(testB));
    }
}