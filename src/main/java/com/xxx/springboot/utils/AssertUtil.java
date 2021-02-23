package com.xxx.springboot.utils;

import com.xxx.springboot.exceptions.ParamsException;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 16:11
 * @Description:com.xxx.springboot.utils
 * @version:v1.0.0
 */
public class AssertUtil {
    public static void isTrue(Boolean flag, String msg) {
        if (flag) {
            throw new ParamsException(msg);
        }

    }

}
