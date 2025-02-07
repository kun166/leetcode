package com.test.sort;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: FastSort2025020701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 11:11
 * @Version: 1.0
 */
public class FastSort2025020701 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 4, 6, 8, 7, 9};
        FastSort2025020701 fastSort = new FastSort2025020701();
        fastSort.sort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < nums[index]) {
                // 交换位置
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index = i;
            }
        }
        sort(nums, l, index - 1);
        sort(nums, index + 1, r);
    }


}
