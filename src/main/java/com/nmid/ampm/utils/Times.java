package com.nmid.ampm.utils;

import org.springframework.stereotype.Component;

/**
 * @author Aaron
 * @description
 * @date 2020/5/26 4:04 PM
 */
public class Times {
    public static int index = 7;
    public static int addIndex(){
        index++;
        return index;
    }
}
