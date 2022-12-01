package com.test.leetcode.page1.chapter80.t80;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20221201
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/1 08:55
 * @Version: 1.0
 */
public class Solution20221201 {

    @Test
    public void test() {
        int[] array = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(JSON.toJSONString(removeDuplicates(array)));
        System.out.println(JSON.toJSONString(array));
    }

    /**
     * 思路
     * 1,定义一个left，标识目前数组长度
     * 2,定义一个count，标识当前字符和前面字符的重复数
     * 3,如果count<=2,则 交换
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length, left = 1, count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                // 交换位置
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
