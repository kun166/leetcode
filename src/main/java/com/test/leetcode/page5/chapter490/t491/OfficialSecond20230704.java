package com.test.leetcode.page5.chapter490.t491;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 15:36
 * @Version: 1.0
 */
public class OfficialSecond20230704 {

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 方法二：递归枚举 + 减枝
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void dfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            dfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[cur] != last) {
            dfs(cur + 1, last, nums);
        }
    }
}
