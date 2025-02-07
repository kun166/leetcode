package com.test.test;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Field;

/**
 * @ClassName: SpringAsmTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/2/18 14:28
 * @Version: 1.0
 */

public class SpringAsmTest {

    @Resource
    private String str;

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println("guide_buy_member".toUpperCase());
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
