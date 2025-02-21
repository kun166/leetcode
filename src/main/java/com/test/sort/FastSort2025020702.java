package com.test.sort;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: FastSort2025020701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 11:11
 * @Version: 1.0
 */
public class FastSort2025020702 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 4, 6, 8, 7, 9};
        FastSort2025020702 fastSort = new FastSort2025020702();
        fastSort.sort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public void sort(int[] nums) {
        int l = 0, r = nums.length - 1, index = l;
        while (l < r) {

        }
    }


}
