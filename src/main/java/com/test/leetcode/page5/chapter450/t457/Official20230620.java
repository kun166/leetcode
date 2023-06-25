package com.test.leetcode.page5.chapter450.t457;

/**
 * @ClassName: Official20230620
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/20 08:49
 * @Version: 1.0
 */
public class Official20230620 {

    /**
     * 方法一：快慢指针
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            // 判断非零且方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int tmp = add;
                add = next(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    /**
     * 寻找从当前坐标跳到的下一个坐标的下标
     *
     * @param nums
     * @param cur
     * @return
     */
    public int next(int[] nums, int cur) {
        int n = nums.length;
        // 这个很牛逼啊，有可能cur + nums[cur]<0
        return ((cur + nums[cur]) % n + n) % n; // 保证返回值在 [0,n) 中
    }
}
