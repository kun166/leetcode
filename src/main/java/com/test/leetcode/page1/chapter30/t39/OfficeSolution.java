package com.test.leetcode.page1.chapter30.t39;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficeSolution
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/15 11:26
 * @Version: 1.0
 */
public class OfficeSolution {
    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum(new int[]{2, 3, 6, 7}, 7)));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 返回结果
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 记录每一次遍历的数
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     * 这个代码很难理解，难以理解
     *
     * @param candidates
     * @param target
     * @param ans
     * @param combine
     * @param idx        这个是数组的下标，用来下一个尝试的数的下标，
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            // 说明遍历到头了
            // 已经是无效数组下标了，不再尝试，返回
            return;
        }
        if (target == 0) {
            // 说明累加和等于目标值了
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        // 先保证数组下标都能访问，且在下面的递归里面，能以当前坐标向前尝试
        // 这个代码看不懂，哈哈
        dfs(candidates, target, ans, combine, idx + 1);
        // 数字下标从后向前访问，length-1,length-2……1
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            System.out.println(JSON.toJSONString(combine));
            // 这个又从当前数组下标开始，累加向前尝试
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
