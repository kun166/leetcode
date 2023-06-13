package com.test.leetcode.page5.chapter440.t448;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official20230613
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/13 09:36
 * @Version: 1.0
 */
public class Official20230613 {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            // 注意 (num-1)%n  是n进制的常规操作
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
