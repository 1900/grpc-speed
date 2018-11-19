package com.funtime.grpc.utils;

public class StrUtil {


    public static boolean isNotEmpty(String str) {
        return !(null == str || str.equals("") || str.length() == 0);
    }

    public static boolean isNotZero(Integer i) {
        return null != i && i != 0;
    }

    public static boolean isNotZero(Double d) {
        return null != d && d != 0;
    }

    public static boolean isNotZero(Long l) {
        return null != l && l != 0;
    }

}
