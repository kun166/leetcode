package com.test.test;

import org.junit.Test;

import java.io.File;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-11-05 10:44
 */
public class FileTest {

    @Test
    public void test() {
        String path = "D:/code/bj58";
        for (String str : new File(path).list()) {
            System.out.println(str);
        }

    }
}
