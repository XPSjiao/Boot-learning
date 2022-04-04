package com.ej.boot.model;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @program: boot-learning
 * @description: @Configuration注解，表示本类为一个配置类
 * @author: EthanJiao
 * @create: 2022-03-14
 **/
@Data
@Configuration //表示是个配置类
@PropertySource(name = "employeeProperties",value = "classpath:employee.properties", encoding = "utf-8")
public class Employee {

    /**
     * 使用SpEL来读取employee.properties的配置文件
     */
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private String firstName;
    @Value("#{${employee.age}}")
    private Map<String,Integer> employeeAge;

    @Value("#{${employee.age}['five'] != null ? ${employee.age}['five']: 80}")
    private Integer ageWithDefaultValue;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
