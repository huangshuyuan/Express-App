package com.hsy.express.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: syhuang
 * Date:  2017/12/26
 */

public class Utils {
    /**
     * 判断空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        if (s.trim().length() == 0)
            return true;
        return false;
    }

    /**
     * 判断是否是手机号
     *
     * @return
     */
    public static boolean isPhone(String phone) {
        //手机号验证表达式
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    public static boolean isLogin() {
        boolean flag = AppConfig.getInstance().getBoolean("isLogin", false);
        return flag;
    }

}
