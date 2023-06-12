package com.test.leetcode.page5.chapter440.t442;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 15:15
 * @Version: 1.0
 */
public class Solution20230609 {

    @Test
    public void test() {
        System.out.println(2 | 1 | 1);
    }

    /**
     * 呃，这方法搞不定
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int number = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            if ((number ^ nums[i]) == 0) {
                ans.add(nums[i]);
            } else {
                number ^= nums[i];
            }
        }
        return ans;
    }
}
