package com.test.leetcode.page1.chapter90.t90;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 17:02
 * @Version: 1.0
 */
public class Solution2025030601 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(subsetsWithDup(new int[]{1, 2, 2})));
    }

    /**
     * 组合容易，排列难啊
     * <p>
     * 又是递归-回溯,继续回忆下
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            /**
             * 对index及index以后的坐标进行选择。对，其实它的本质还是选择
             * 本次循环内,会选择每一个数,一旦选了就放到了list中了……
             */

            if (i > index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backtrack(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
