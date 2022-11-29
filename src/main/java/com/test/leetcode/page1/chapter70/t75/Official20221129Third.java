package com.test.leetcode.page1.chapter70.t75;

/**
 * @ClassName: Official20221129Third
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/29 12:33
 * @Version: 1.0
 */
public class Official20221129Third {

    public void sortColors(int[] nums) {
        int n = nums.length;
        // p0是下一个0需要换到的地方,p2是下一个2需要换到的地方
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
