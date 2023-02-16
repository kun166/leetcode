package com.test.leetcode.page2.chapter180.t189;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 14:23
 * @Version: 1.0
 */
public class SolutionFirst20230215 {

    @Test
    public void test() {
        int[] nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        System.out.println(JSON.toJSONString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        int curr = 0, currNumber = nums[curr], index, indexNumber, start = curr;
        for (int i = 0; i < n; i++) {
            index = (curr + k) % n;
            indexNumber = nums[index];
            nums[index] = currNumber;
            // 转换进行下一次循环
            curr = index;
            currNumber = indexNumber;
            if (curr == start) {
                // 如果n%k==0,则会造成循环
                curr = start = curr + 1;
                currNumber = nums[curr];
            }
        }
    }
}
