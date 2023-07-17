package com.test.test;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName: LeetCodePackage
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 08:46
 * @Version: 1.0
 */
public class LeetCodePackage {

    @Test
    public void create() {
        int number = 590;
        String path = "/Users/qinfajia/code/study/leetcode/src/main/java/com/test/leetcode/page6/chapter" + number;

        for (int i = 0; i <= 9; i++) {
            new File(path + File.separator + "t" + (number + i)).mkdir();
        }
        System.out.println(new File(path).exists());
    }
}
