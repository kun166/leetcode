package com.test.leetcode.page5.chapter440.t443;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Official20230612
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/12 08:38
 * @Version: 1.0
 */
public class Official20230612 {

    @Test
    public void test() {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
        System.out.println(JSON.toJSONString(chars));
    }

    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {

            if (read == n - 1 || chars[read] != chars[read + 1]) {
                // 如果已经读到了结尾，或者下一个字符和当前字符不一样
                // write是写的位置……
                chars[write++] = chars[read];
                // 连续相同字符长度
                int num = read - left + 1;
                if (num > 1) {
                    // 如果长度大于1
                    int anchor = write;
                    while (num > 0) {
                        // 将大于等于10的数字转成char表示
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    /**
     * 翻转，因为数字先写的低位，再写的高位，翻转过来
     *
     * @param chars
     * @param left
     * @param right
     */
    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
