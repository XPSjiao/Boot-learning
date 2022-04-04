package com.ej.article.util;

import java.util.Random;

/**
 * @program: uni-article-api
 * @description:
 * @author: yy
 * @create: 2022-03-23 15:12
 **/
public class StringUtil {
    private final static int LENGTH = 6;

    /**
     * 获取六位随机数据短信验证码
     *
     * @return
     */
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}