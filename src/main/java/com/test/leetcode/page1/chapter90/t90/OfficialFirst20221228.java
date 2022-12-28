package com.test.leetcode.page1.chapter90.t90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: OfficialFirst20221228
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/28 09:04
 * @Version: 1.0
 */
public class OfficialFirst20221228 {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<Integer>(t));
            }
        }
        return ans;
    }
}
