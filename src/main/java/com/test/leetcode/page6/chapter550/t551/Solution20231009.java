package com.test.leetcode.page6.chapter550.t551;

/**
 * @ClassName: Solution20231009
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/10/9 09:39
 * @Version: 1.0
 */
public class Solution20231009 {

    /**
     * 呃，一个简单题都做错了，汗
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int l = 0, a = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                if (++l == 3)
                    return false;
                continue;
            }
            if (c == 'A' && ++a == 2) {
                return false;
            }
            l = 0;
        }
        return true;
    }
}
