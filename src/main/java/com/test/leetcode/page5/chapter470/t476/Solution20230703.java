package com.test.leetcode.page5.chapter470.t476;

import org.junit.Test;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 09:31
 * @Version: 1.0
 */
public class Solution20230703 {

    @Test
    public void test() {
        System.out.println(findComplement(2));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了51.87%的用户
     * 通过测试用例：149 / 149
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int ans = 0;
        int right = 1;
        while (num > 0) {
            if (num % 2 == 0) {
                ans += right;
            }
            num >>= 1;
            right <<= 1;
        }
        return ans;
    }
}
