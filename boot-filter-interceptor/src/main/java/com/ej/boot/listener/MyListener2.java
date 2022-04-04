package com.ej.boot.listener;

import com.ej.boot.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

    @Component
    @Slf4j
    public class MyListener2 implements ApplicationListener<MyEvent> {
        @Override
        public void onApplicationEvent(MyEvent event) {
            log.info(String.format("%s监听到事件源:%s.", MyListener2.class.getName(),event.getSource()));
        }
    }