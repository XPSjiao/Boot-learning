package com.ej.boot.listener;

import com.ej.boot.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

@Slf4j
@Component
public class MyListener4 {
    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s监听到事件源:%s.", MyListener4.class.getName(), event.getSource()));
    }
}