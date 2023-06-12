package com.test.leetcode.page5.chapter440.t444;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution20230612
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/12 09:10
 * @Version: 1.0
 */
public class Solution20230612 {

    /**
     * 呃，这题……这个感觉是有向图
     *
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (List<Integer> list : sequences) {
            for (int i = 0; i < list.size() - 1; i++) {
                set.add(i);
                if (map.get(list.get(i)) > map.get(list.get(i + 1))) {
                    return false;
                }
            }
            set.add(list.get(list.size() - 1));
        }
        return set.size() == n;
    }
}
