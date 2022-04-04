package com.ej.boot.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner参数名称:{}",args.getOptionNames());
        log.info("ApplicationRunner-->username的参数值:{}",args.getOptionValues("username"));
        log.info("ApplicationRunner参数:{}", Arrays.toString(args.getSourceArgs()));
    }
}