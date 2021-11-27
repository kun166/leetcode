package com.test.string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: Regular
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/11/25 14:53
 * @Version: 1.0
 */
public class Regular {

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("\\ba\\w*\\b");
        Matcher matcher = pattern.matcher("abc");
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
