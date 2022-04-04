package com.yy.article.dozer;

import com.ej.article.dozer.TestA;
import com.ej.article.dozer.TestB;
import com.ej.article.dozer.TestaVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class DozerTest {

    @Test
    void BeanUtilsTest() {
        TestA testA = TestA.builder().name("zhangsan").build();
        TestaVO testaVO = new TestaVO();
        BeanUtils.copyProperties(testA, testaVO);
        System.out.println(testaVO);
    }

    @Test
    void dozerTest() {
        TestA testA = new TestA("zhangsan", "2022-03-28 11:11:11");
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        TestB testB = mapper.map(testA, TestB.class);
        //打印结果
        //TestB(name=zhangsan, cDate=null)
        System.out.println(testB);
    }

    @Test
    void dozerTest1() {
        Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles("dozer/dozer-mapping.xml").build();
        TestA testA = new TestA("zhangsan", "2022-03-28 11:11:11");
        //打印结果
        //TestB(name=zhangsan, cDate=Mon Mar 28 11:11:11 CST 2022)
        System.out.println(mapper.map(testA,TestB.class));
    }

}