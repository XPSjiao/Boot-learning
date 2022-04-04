package com.ej.boot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: boot-learning
 * @description: 自定义监听器
 * @author: EthanJiao
 * @create: 2022-04-04
 **/
@Slf4j
@WebListener
public class CustomeListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("====================context创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("====================context销毁");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
       if ("a".equals(srae.getName())){
           log.info("====================attribute Added值为" + srae.getValue());
       }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        if ("a".equals(srae.getName())){
            log.info("====================attribute Removed");
        }
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        if ("a".equals(srae.getName())){
            log.info("====================attribute Replaced");
        }
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("====================request监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("====================request监听器：创建");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("====================session 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("====================session 销毁");
    }
}
