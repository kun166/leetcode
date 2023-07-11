package com.test.leetcode.page5.chapter490.t496;

/**
 * @ClassName: Solution20230711
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/11 09:45
 * @Version: 1.0
 */
public class Solution20230711 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了90.25%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了94.79%的用户
     * 通过测试用例：16 / 16
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = -1;
            // 找出下标
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }
            for (int j = index + 1; j < n; j++) {
                if (nums2[j] > nums2[index]) {
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
