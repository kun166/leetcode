package com.test.leetcode.page1.chapter10.t12;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 11:08
 * @Version: 1.0
 */
public class Solution20250211 {

    public String intToRoman(int num) {
        char[] c = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int index = 0;
        // 记录返回的数
        StringBuffer buffer = new StringBuffer();
        while (num > 0) {
            // 从低位往高位
            int n = num % 10;
            num = num / 10;
            if (n > 0 && n < 4) {
                while (--n >= 0) {
                    buffer.append(c[index * 2]);
                }
            } else if (n == 4) {
                buffer.append(c[index * 2 + 1]);
                buffer.append(c[index * 2]);
            } else if (n == 5) {
                buffer.append(c[index * 2 + 1]);
            } else if (n > 5 && n < 9) {
                while (--n >= 5) {
                    buffer.append(c[index * 2]);
                }
                buffer.append(c[index * 2 + 1]);
            } else if (n == 9) {
                buffer.append(c[index * 2 + 2]);
                buffer.append(c[index * 2]);
            }
            index++;
        }
        return buffer.reverse().toString();
    }
}
