package com.test.leetcode.page5.chapter450.t456;

import java.util.TreeMap;

/**
 * @ClassName: OfficialFirst20230619
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/19 09:07
 * @Version: 1.0
 */
public class OfficialFirst20230619 {

    /**
     * 方法一：枚举3
     * <p>
     * 执行用时：135 ms, 在所有 Java 提交中击败了8.37%的用户
     * 内存消耗：72.3 MB, 在所有 Java 提交中击败了5.16%的用户
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

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        // key是数组存放的值，value是该值出现的次数
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            // 初始化rightAll
            // 注意这个里面没初始化k==1的情况，原因下面有解释
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                // leftMin是1,nums[j]是3,查找2
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            // 更新最小值
            leftMin = Math.min(leftMin, nums[j]);
            // 下一个循环是j+1了，j+1作为3，就不能作为2了
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }
}
