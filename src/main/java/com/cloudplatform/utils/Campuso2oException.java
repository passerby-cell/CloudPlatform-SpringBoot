package com.cloudplatform.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/28/11:33 下午
 * @Description: 打包异常
 */
public class Campuso2oException extends RuntimeException{
    public Campuso2oException(String origin){
        super("{"+origin+"}发生了异常：");
    }
    public Campuso2oException(String origin,Exception ex){
        super("{"+origin+"}发生了异常："+parseErrMsg(ex));

    }

    private static String parseErrMsg(Exception ex) {
        if(ex == null){
            return "异常堆栈获为空";
        }
        String errMsg = "";
        StackTraceElement[] stackTrace = ex.getStackTrace();
        for (StackTraceElement s : stackTrace) {
            errMsg+="\tat " + s + "\r\n";
        }
        return errMsg;
    }
}


