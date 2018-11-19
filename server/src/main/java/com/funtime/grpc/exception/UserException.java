package com.funtime.grpc.exception;

import java.util.HashMap;
import com.funtime.grpc.exception.BusinessException;

public class UserException extends BusinessException {
    public UserException(String code) {
        super(code, errorMsgMap.get(code));
    }


    public static final String USER_EXCEPTION_USERNAME_OR_PASSWORD_ERROR = "4000001";
    public static final String USER_EXCEPTION_USER_NOT_FOUND = "4000002";

    private static final HashMap<String, String> errorMsgMap;
    static {
        errorMsgMap = new HashMap<>();
        errorMsgMap.put(USER_EXCEPTION_USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
        errorMsgMap.put(USER_EXCEPTION_USER_NOT_FOUND, "用户不存在");
    }
}
