package com.ej.boot.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * @program: boot-learning
 * @description: 务必注意 成员变量名 要和yaml配置的key一一对应
 * @author: EthanJiao
 * @create: 2022-03-15
 **/
@Data
@Component //这个注解使用之后可以直接由容器注入，而不用new一个了 @Autowired这个注解进行注入

/**
 * 配置整体前缀
 */
@ConfigurationProperties(prefix = "family")

@Validated//校验

@PropertySource(value = {"classpath:family.properties"})
public class Family {

//    @Value("${family.family-name}") //可以自动找到我们配置文件当中的family  下面的 family-name属性 把它绑定到这里
    @Length(min = 5 ,max = 30 , message = "家庭名称的长度必须在5-20位之间")
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
