package com.test.leetcode.page5.chapter490.t491;

import java.util.*;

/**
 * @ClassName: Solution20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 11:08
 * @Version: 1.0
 */
public class Solution20230704 {

    private Set<String> set = new HashSet<>();

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了5.05%的用户
     * 内存消耗：51.6 MB, 在所有 Java 提交中击败了9.33%的用户
     * 通过测试用例：58 / 58
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ds(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public void ds(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index == nums.length) {
            // 结束
            if (list.size() > 1) {
                String key = join(list);
                if (!set.contains(key)) {
                    set.add(key);
                    ans.add(new ArrayList<>(list));
                }
            }
            return;
        }

        if (list.size() > 1) {
            String key = join(list);
            if (!set.contains(key)) {
                set.add(key);
                ans.add(new ArrayList<>(list));
            } else
                return;
        }
        for (int i = index; i < nums.length; i++) {
            boolean add = list.size() == 0 || nums[i] >= list.get(list.size() - 1);
            if (add) {
                list.add(nums[i]);
            }
            ds(nums, ans, list, i + 1);
            if (add) {
                list.remove(list.size() - 1);
            }
        }
    }

    public String join(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i : list) {
            builder.append(i).append("-");
        }
        return builder.toString();
    }

}
