package com.test.leetcode.page2.chapter170.t179;

import java.util.Arrays;

/**
 * @ClassName: Solution2025032501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 09:01
 * @Version: 1.0
 */
public class Solution2025032501 {

    /**
     * 3ms	击败96.34%
     * 41.17MB	击败92.59%
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        // 1,先把数字换成字符串
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            /**
             * 好吧……
             * 这个地方还试图new String(int);
             * 结果失败……失败……
             * 最好的方式就是{@link String#valueOf(int)}
             */
            array[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(array, (s1, s2) -> {
            int i1 = 0, i2 = 0;
            while (true) {
                if (s1.charAt(i1) != s2.charAt(i2)) {
                    return s1.charAt(i1) - s2.charAt(i2);
                }
                i1++;
                i2++;
                if (i1 == s1.length() && i2 == s2.length()) {
                    return 0;
                }
                if (i1 == s1.length()) {
                    i1 = 0;
                }
                if (i2 == s2.length()) {
                    i2 = 0;
                }
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]);
        }
        /**
         * 唉，在nums是{0,0}的时候挂了……
         */
        return builder.charAt(0) == '0' ? "0" : builder.toString();
    }
}
