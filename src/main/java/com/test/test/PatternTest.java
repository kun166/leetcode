package com.test.test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: PatternTest
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/15 09:15
 * @Version: 1.0
 */
public class PatternTest {

    @Test
    public void match() {
        String s = "data:image/png;base64,1234";
        Pattern pattern = Pattern.compile("^data:image/(jpeg|png|gif);base64,");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
    }
}
