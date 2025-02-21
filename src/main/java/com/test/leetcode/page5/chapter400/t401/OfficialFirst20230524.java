package com.test.leetcode.page5.chapter400.t401;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230524
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/24 09:57
 * @Version: 1.0
 */
public class OfficialFirst20230524 {

    /**
     * 方法一：枚举时分
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }

}
