package com.ej.boot.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
//上面两个注解写上才能使用Spring的注入
class FamilyTest {
    @Autowired
    private Family family;

    @Test
    void printFamily(){
        System.out.println(family);
    }


}