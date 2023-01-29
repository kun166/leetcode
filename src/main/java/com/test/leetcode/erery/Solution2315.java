package com.test.leetcode.erery;

/**
 * @ClassName: Solution2315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 08:57
 * @Version: 1.0
 */
public class Solution2315 {

    /**
     * 呃，这个题确实是一个非常非常简单的题目。
     * 这个解法想的复杂了，因为题目中有明确说明：注意，每个竖线 '|' 都会 恰好 属于一个对。
     *
     * @param s
     * @return
     */
    public int countAsterisks(String s) {
        // 1,还没寻找到第一个|
        // 2,已经寻找到第一个|
        // 3,寻找到配对的|
        int ans = 0;
        int curCount = 0;
        int type = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                if (type == 0) {
                    type = 1;
                } else if (type == 1) {
                    curCount = 0;
                    type = 0;
                }
            } else if (c == '*') {
                if (type == 0) {
                    ans++;
                } else {
                    curCount++;
                }
            }
        }
        return ans + curCount;
    }
}
