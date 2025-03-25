package com.test.leetcode.page2.chapter180.t189;

/**
 * @ClassName: OfficialFirst20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 15:41
 * @Version: 1.0
 */
public class OfficialFirst20230215 {

    /**
     * 呃， 这个方式比SolutionSecond20230215慢
     * 这就说明原生的System.arraycopy()确实牛啊
     * <p>
     * 唉,这……这……
     * 想出来这方法的也是天才
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
