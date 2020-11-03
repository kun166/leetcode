package com.test.leetcode.chapter40.t46;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-30 10:26
 */
public class OfficialSolution {

    @Test
    public void test() {
        List<List<Integer>> result = permute(new int[]{1, 2, 3, 4, 5});
        for (List<Integer> l : result) {
            System.out.println();
            for (Integer i : l) {
                System.out.print(i + ",");
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        // output先进行一次数组复制
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }


    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组。置换first和i的位置
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作。再置换回来
            Collections.swap(output, first, i);
        }
    }
}
