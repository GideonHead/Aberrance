package com.zepsun.aberrance.util;

public class ModUtil {
    public static <T> boolean notNull(T variable) {
        if(variable == null) {
            return true;
        }
        return false;
    }
}
