package com.ej.boot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

@Configuration
public class BeanRunner {
    @Bean
    @Order(2)
    public CommandLineRunner runner1() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("BeanCommandLinRunner run1()" + Arrays.toString(args));
            }
        };
    }
    @Bean
    @Order(1)
    public CommandLineRunner runner2() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("BeanCommandLinRunner run2()" + Arrays.toString(args));
            }
        };
    }
    @Bean
    @Order(1)
    public ApplicationRunner runner3() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("ApplicationRunner run3()" + Arrays.asList(args));
            }
        };
    }
    @Bean
    @Order(2)
    public ApplicationRunner runner4() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("ApplicationRunner run4()" + Arrays.asList(args));
            }
        };
    }

}
