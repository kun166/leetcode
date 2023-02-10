package com.test.leetcode.page2.chapter160.t168;

import org.junit.Test;

/**
 * @ClassName: Hex20230210
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/10 09:11
 * @Version: 1.0
 */
public class Hex20230210 {

    @Test
    public void test() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(convertToHex(i) + ":" + Integer.toHexString(i));
        }

    }

    public String convertToHex(int columnNumber) {
        if (columnNumber == 0) {
            return "0";
        }
        StringBuffer buffer = new StringBuffer();
        while (columnNumber > 0) {
            // 对columnNumber取16的余数，则hex刚好是0到15中的一个，分别对应0到F
            int hex = columnNumber % 16;
            if (hex < 10) {
                buffer.append(hex);
            } else {
                buffer.append((char) ('A' + hex - 10));
            }

            // 继续下一次循环。
            // 仔细想想，这个地方的代码准确来说应该是
            // columnNumber = (columnNumber - hex) / 16;
            // 只是因为hex是一个0到15之间的数字，整除16之后是0，所以给精简了
            columnNumber /= 16;
        }
        return buffer.reverse().toString();
    }


}
