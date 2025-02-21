package com.test.leetcode.page1.chapter30.t38;

/**
 * @ClassName: Solution2025022101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/21 16:32
 * @Version: 1.0
 */
public class Solution2025022102 {

    /**
     * 迭代吧
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder first = new StringBuilder("1");
        StringBuilder second = new StringBuilder();
        while (n > 1) {
            int count = 1;
            char c = first.charAt(0);
            for (int i = 1; i < first.length(); i++) {
                if (first.charAt(i) == first.charAt(i - 1)) {
                    count++;
                } else {
                    second.append(count).append(c);
                    count = 1;
                    c = first.charAt(i);
                }
            }
            second.append(count).append(c);
            StringBuilder temp = first;
            first = second;
            second = temp;
            second.delete(0, second.length());
            n--;
        }
        return first.toString();
    }
}
