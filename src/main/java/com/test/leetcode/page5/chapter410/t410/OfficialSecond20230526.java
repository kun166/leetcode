package com.test.leetcode.page5.chapter410.t410;

/**
 * @ClassName: OfficialSecond20230526
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/26 09:31
 * @Version: 1.0
 */
public class OfficialSecond20230526 {

    /**
     * 方法二：二分查找 + 贪心
     * <p>
     * 呃，这个解法真的很牛逼啊
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        // left下界，right上界
        // left是数组nums中单个最大的数，right是nums数组中的累加和
        int left = 0, right = 0;
        // 求left和right
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 对nums进行分段，每个分段内的累加和不超过x,查过x则拆分分段。返回分段数是否小于等于m
     *
     * @param nums 目标数组
     * @param x    分段累加和的最大值
     * @param m    要求的分段数
     * @return
     */
    public boolean check(int[] nums, int x, int m) {
        // 分段内的累加和
        int sum = 0;
        // 分段数
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                // 如果分段内的累加和大于x，则拆分
                // 分段数+1
                cnt++;
                // 重新计算新的分段累加和
                sum = nums[i];
            } else {
                // 不超过就继续累加
                sum += nums[i];
            }
        }
        // 判断分段数是否小于等于m
        return cnt <= m;
    }

}
