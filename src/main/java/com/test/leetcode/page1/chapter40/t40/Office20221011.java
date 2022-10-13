package com.test.leetcode.page1.chapter40.t40;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Office20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 14:57
 * @Version: 1.0
 */
public class Office20221011 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)));
    }

    // 存储数组中数字出现的次数。int[] 是长度为2的数组，int[0]是数组中的数字，int[1]是该数字出现的次数
    List<int[]> freq = new ArrayList<>();
    // 需要返回的结果
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();


    /**
     * 这个实现方式也很难以理解，但是也是一种解法，需要细细品味
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    /**
     * @param pos  位置下标
     * @param rest 目标值
     */
    public void dfs(int pos, int rest) {
        if (rest == 0) {
            // 目标达成，记录起来
            ans.add(new ArrayList<>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            // 下标越界，或者是目标值小于最小值了，则退出
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
