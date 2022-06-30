package com.cloudplatform.utils;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/30/12:40 下午
 * @Description:
 */
public class PortUtil {

    public static int getFreePort(int start) {
        for (int i = start; i <= 65535; i++) {
            try {
                new ServerSocket(i).close();
                return i;
            } catch (IOException e) { // 抛出异常表示不可以，则进行下一个
                continue;
            }
        }
        return -1;
    }
}
