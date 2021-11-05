package com.test.leetcode.page2.chapter150.t152;

/**
 * 牛逼
 *
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-04 17:52
 */
public class SolutionOfficeFirst {

    public int maxProduct(int[] nums) {
        /*思想：双指针，遇到0左指针开始收敛*/
        int n = nums.length;
        if (n == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int muti = 1;
        int l = 0, r = 0;
        while (r <= n && l < n) {
            if (r == n) {//如果右指针到达最后一个位置，左指针开始滑动
                muti /= nums[l++];
            } else {
                if (nums[r] != 0) {//如果右指针所指元素不为0，右滑，更新muti
                    muti *= nums[r++];
                } else if (l < r) {//右指针为0，开始左滑，更新muti
                    muti /= nums[l++];
                } else {//左右指针都滑到了0的位置，更新max，左右指针指向下一位置重新滑动
                    max = Math.max(max, 0);
                    ++l;
                    ++r;
                }
            }
            //只要左右指针没有指向同一位置，更新max（指向同一位置说明左滑到顶了，记录的muti一定为1，但并不是乘积值）
            if (l != r) max = Math.max(max, muti);
        }
        return max;
    }
}
