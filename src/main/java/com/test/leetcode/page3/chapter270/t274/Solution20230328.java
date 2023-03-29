package com.test.leetcode.page3.chapter270.t274;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230328
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/28 09:56
 * @Version: 1.0
 */
public class Solution20230328 {

    @Test
    public void test() {
        System.out.println(hIndex(new int[]{100}));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了83%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了52.85%的用户
     * 通过测试用例：81 / 81
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int ans = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > ans) {
                ans++;
            }
        }
        return ans;
    }
}
