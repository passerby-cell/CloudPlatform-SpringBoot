package com.cloudplatform.utils;

/**
 * 返回码
 */
public class StatusCode {
    public static final int OK = 200;//成功
    public static final int TOKENERROR = 201;//token校验失败
    public static final int LOGINERROR = 202;//用户名或密码错误
    public static final int ACCESSERROR = 203;//权限不足
    public static final int REMOTEERROR = 204;//远程调用失败
    public static final int REPAETERROR = 205;//用户名重复
    public static final int NOTFOUNDERROR = 206;//没有对应的数据
    public static final int EERROR = 207;//
}
