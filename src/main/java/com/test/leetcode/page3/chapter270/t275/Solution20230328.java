package com.test.leetcode.page3.chapter270.t275;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230328
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/29 09:45
 * @Version: 1.0
 */
public class Solution20230328 {

    @Test
    public void test() {
        System.out.println(hIndex(new int[]{0}));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：48.3 MB, 在所有 Java 提交中击败了45.74%的用户
     * 通过测试用例：83 / 83
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] > citations.length - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - right;
    }
}
