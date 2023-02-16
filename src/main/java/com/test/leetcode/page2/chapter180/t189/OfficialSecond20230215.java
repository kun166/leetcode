package com.test.leetcode.page2.chapter180.t189;

/**
 * @ClassName: OfficialSecond20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 15:57
 * @Version: 1.0
 */
public class OfficialSecond20230215 {

    /**
     * 环状替换
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    /**
     * 求最大公约数，又来了
     *
     * @param x
     * @param y
     * @return
     */
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
