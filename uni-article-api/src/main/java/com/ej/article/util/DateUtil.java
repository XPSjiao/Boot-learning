package com.ej.article.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-29 15:24
 **/
@Component
public class DateUtil {
    public static void main(String[] args) {
        DateUtil dateUtil = new DateUtil();
        System.out.println(dateUtil.randomDate());
    }
    public LocalDate randomDate() {
        //随机生成日期和时间
        Random random = new Random();
        int minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2022, 3, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;

    }
}