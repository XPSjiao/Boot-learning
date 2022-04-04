package com.ej.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: boot-learning
 * @description:
 * @author: EthanJiao
 * @create: 2022-04-04
 **/

public class FormatUtils {
    public static String forTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
