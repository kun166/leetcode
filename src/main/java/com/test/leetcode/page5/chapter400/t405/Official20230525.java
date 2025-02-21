package com.test.leetcode.page5.chapter400.t405;

import org.junit.Test;

/**
 * @ClassName: Official20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 14:28
 * @Version: 1.0
 */
public class Official20230525 {

    @Test
    public void test() {
        System.out.println(toHex(-155));
    }

    /**
     * 感觉是真的牛逼啊
     *
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i--) {
            // 从高位到低位进行计算。这样的好处是高位的0可以忽略掉
            // 位运算，获取的值与0xf进行与，保证0-15
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                // 这个if条件设置的很好啊
                // 后面这个'a' + val - 10也很好
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
