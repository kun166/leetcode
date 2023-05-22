package com.test.leetcode.page4.chapter340.t349;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230508
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/8 09:27
 * @Version: 1.0
 */
public class Solution20230508 {

    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了5.21%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了95.61%的用户
     * 通过测试用例：55 / 55
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j && !list.contains(i)) {
                    list.add(i);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
