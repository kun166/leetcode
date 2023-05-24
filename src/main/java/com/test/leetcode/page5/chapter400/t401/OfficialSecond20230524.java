package com.test.leetcode.page5.chapter400.t401;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230524
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/24 09:58
 * @Version: 1.0
 */
public class OfficialSecond20230524 {

    /**
     * 方法二：二进制枚举
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        // 呃，这个时钟占4位，分钟占6位
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}
