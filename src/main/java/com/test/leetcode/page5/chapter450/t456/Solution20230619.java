package com.test.leetcode.page5.chapter450.t456;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230619
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/19 07:39
 * @Version: 1.0
 */
public class Solution20230619 {

    /**
     * 132的情况：
     * 1要尽量小,3要尽量大,2介于1和3之间
     * <p>
     * 执行用时：141 ms, 在所有 Java 提交中击败了5.64%的用户
     * 内存消耗：61 MB, 在所有 Java 提交中击败了65.06%的用户
     * 通过测试用例：102 / 102
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        List<int[]> list = new ArrayList<>();
        int[] arr = new int[]{0, -1};
        list.add(arr);
        for (int i = 1; i < n; i++) {
            // 取最后一个
            int[] last = list.get(list.size() - 1);
            if (last[1] == -1) {
                if (nums[i] > nums[last[0]]) {
                    last[1] = i;
                } else if (nums[i] < nums[last[0]]) {
                    last[0] = i;
                }
            } else {
                if (nums[i] > nums[last[1]]) {
                    last[1] = i;
                } else if (nums[i] < nums[last[0]]) {
                    arr = new int[]{i, -1};
                    list.add(arr);
                } else if (nums[i] > nums[last[0]] && nums[i] < nums[last[1]]) {
                    return true;
                }
            }
            // 遍历list，查找结果，删除不需要的元素
            for (int j = 0; j < list.size() - 1; j++) {
                arr = list.get(j);
                // 符合要求，返回
                if (nums[arr[1]] > nums[i] && nums[arr[0]] < nums[i]) {
                    return true;
                }
                // 如果 arr[1]对应的下标小于等于当前i的坐标值，则删除
                if (nums[arr[1]] <= nums[i]) {
                    list.remove(j);
                    j--;
                }

            }
        }
        return false;
    }
}
