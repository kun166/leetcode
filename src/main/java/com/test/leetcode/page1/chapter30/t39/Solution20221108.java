package com.test.leetcode.page1.chapter30.t39;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221108
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/8 15:52
 * @Version: 1.0
 */
public class Solution20221108 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum(new int[]{2, 3, 6, 7}, 7)));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }


    public void combinationSum(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], ans, list, i);
            list.remove(list.size() - 1);
        }
    }
}
