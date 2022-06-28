package com.cloudplatform.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/25/12:31 下午
 * @Description:
 */
public class FileSizeUtil {
    /**
     * 判断文件大小
     *
     * @param len  文件长度
     * @param unit 限制单位（B,K,M,G）
     * @return
     */
    public static double checkFileSize(Long len, String unit) {
//        long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        return fileSize;
    }
}
