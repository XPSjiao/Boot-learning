package com.ej.boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);
    }
}
