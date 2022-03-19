package com.test.leetcode.page1.chapter40.t46;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-28 17:33
 */
public class Solution2020102801 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(permute(new int[]{1, 2, 3})));
    }

    /**
     * 递归+回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        permute(result, list, nums, 0);
        return result;
    }

    /**
     * 这种思路是把同一个数，即nums[index]插入到不同的位置
     *
     * @param result
     * @param list
     * @param nums
     * @param index
     */
    public void permute(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 模拟杨辉三角。注意不能是i=0;i<nums.leng,那样就是笛卡尔积了
//        for (int i = 0; i <= list.size(); i++) {
//            // 这个地方必须选择nums[index]，只有这样，才会每次循环里面，保证这个值是不变的，且把数组nums顺序选择了一遍，变化的只是插入的位置
//            // 同样的，插入的位置i，每一次循环都需要变
//            list.add(i, nums[index]);
//            permute(result, list, nums, index + 1);
//            list.remove(i);
//        }
        // 其实下面的代码更容易理解
        for (int i = list.size(); i >= 0; i--) {
            list.add(i, nums[index]);
            permute(result, list, nums, index + 1);
            list.remove(i);
        }
    }
}
