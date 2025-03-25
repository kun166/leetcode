package com.test.leetcode.page2.chapter180.t189;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution2025032502
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/25 17:19
 * @Version: 1.0
 */
public class Solution2025032502 {

    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
        System.out.println(JSON.toJSONString(array));
    }

    /**
     * 面试中肯定不会这么尝试……
     * 仅仅只是尝试……
     * <p>
     * 果然不太行啊
     * nums =[1,2,3,4,5,6]
     * k = 4
     * 输出:[3,2,5,4,1,6]
     * 预期结果:[3,4,5,6,1,2]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        /**
         * 好吧,好吧……
         */
        if (k == 0)
            return;
        int index = 0, nextIndex, first, second;
        if (n % k == 0) {
            for (int i = 0; i < k; i++) {
                index = i;
                first = nums[index];
                do {
                    nextIndex = (index + k) % n;
                    second = nums[nextIndex];
                    nums[nextIndex] = first;
                    index = nextIndex;
                    first = second;
                } while (index != i);
            }
            return;
        }
        /**
         * n不是k的倍数的时候
         */
        first = nums[index];
        do {
            nextIndex = (index + k) % n;
            second = nums[nextIndex];
            nums[nextIndex] = first;
            index = nextIndex;
            first = second;
        } while (index != 0);

    }
}
