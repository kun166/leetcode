package com.test.leetcode.page2.chapter130.t131;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025031401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 14:18
 * @Version: 1.0
 */
public class Solution2025031402 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(partition("cdd")));
    }

    /**
     * 来个DP吧
     * 17ms	击败7.90%
     * 60.18MB	击败5.00%
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        int n = s.length();
        // dp[i]标识下标为i的字符到结束,拥有的组合
        List<List<String>>[] dp = new List[n + 1];
        /**
         * 非常非常重要,这个地方一定不能这么用
         * 这么用之后,整个dp都是同一个ArrayList……
         * Arrays.fill(dp, new ArrayList<>());
         */
        // 初始化,下标为n的字符其实是不存在的，我们赋值一个空的
        dp[n] = new ArrayList<>();
        dp[n].add(new ArrayList<>());
        for (int i = n - 1; i >= 0; i--) {
            // 从后向前
            dp[i] = new ArrayList<>();
            // i到字符串末尾的字符个数
            int length = n - i;
            for (int j = 1; j <= length; j++) {
                if (match(s, i, i + j - 1)) {
                    List<List<String>> list = dp[i + j];
                    for (List<String> l : list) {
                        List<String> nl = new ArrayList<>();
                        nl.add(s.substring(i, i + j));
                        nl.addAll(l);
                        dp[i].add(nl);
                    }
                }
            }
        }
        return dp[0];
    }

    public boolean match(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
