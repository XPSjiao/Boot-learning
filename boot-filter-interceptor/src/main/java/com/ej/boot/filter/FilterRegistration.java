package com.ej.boot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/
@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CustomFilter());
        //过滤器名称
        registrationBean.setName("customFilter");
        //   拦截路径
        registrationBean.addUrlPatterns("/*");
        //设置顺序，数字越小优先级越高
        registrationBean.setOrder(10);
        return registrationBean;

    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        //过滤器名称
        registrationBean.setName("myFilter");
        //   拦截路径
        registrationBean.addUrlPatterns("/*");
        //设置顺序，数字越小优先级越高
        registrationBean.setOrder(9);
        return registrationBean;

    }

}