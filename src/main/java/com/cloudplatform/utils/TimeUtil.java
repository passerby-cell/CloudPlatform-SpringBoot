package com.cloudplatform.utils;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/22/4:31 下午
 * @Description:
 */
public class TimeUtil {

    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(System.currentTimeMillis());
        return now;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(System.currentTimeMillis());
        System.out.println(now);
    }
}
