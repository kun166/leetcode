package com.test.other;

import org.junit.Test;
import sun.misc.Contended;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: TestFlash
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/11/25 15:54
 * @Version: 1.0
 */
public class TestFlashONODK8 {

    @Test
    public void test() {
        byte a = 127;
        byte b = 127;
        //b = a + b; // error : cannot convert from int to byte
        b += a; // ok
    }

    public boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}



