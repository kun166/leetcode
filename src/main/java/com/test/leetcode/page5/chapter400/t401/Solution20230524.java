package com.test.leetcode.page5.chapter400.t401;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230524
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/24 09:53
 * @Version: 1.0
 */
public class Solution20230524 {

    /**
     * 呃，跟官网学学，汗
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return ans;

    }
}
