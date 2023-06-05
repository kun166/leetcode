package com.test.leetcode.page5.chapter420.t424;

/**
 * @ClassName: Official20230602
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/2 14:28
 * @Version: 1.0
 */
public class Official20230602 {

    /**
     * 这个题目真的是牛逼plus，我感觉是个困难题都不为过，居然就这么解决了？
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        // s的字符数组
        char[] charArray = s.toCharArray();
        // 双指针
        int left = 0;
        int right = 0;

        // 返回结果
        int res = 0;
        // 记录最频繁字符的出现次数
        int maxCount = 0;
        // 记录s中字符出现的次数
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len) {
            // 当前字符出现次数+1
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            // 更新最频繁字符出现次数
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            // 循环下一个字符
            right++;

            if (right - left > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
