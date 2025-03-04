package com.test.leetcode.page1.chapter70.t78;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/4 20:00
 * @Version: 1.0
 */
public class Solution2025030401 {

    /**
     * 继续递归-回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        /**
         * 我擦，这地方居然犯了直接
         * ans.add(list);
         * 的低级错误……
         */
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            /**
             * 麻蛋啊，这个地方居然又犯了
             * list.add(i);
             * 的低级错误
             */
            list.add(nums[i]);
            backtrack(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
