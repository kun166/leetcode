package com.test.leetcode.page3.chapter230.t239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: OfficialSecond20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 08:38
 * @Version: 1.0
 */
public class OfficialSecond20230310 {

    /**
     * 方法二：单调队列
     * 这方法真是妙啊，单调栈还是不熟悉啊
     * <p>
     * 如果当前的滑动窗口中有两个下标 i 和 j，其中 i 在 j 的左侧（i<j），
     * 并且 i 对应的元素不大于 j 对应的元素（nums[i]≤nums[j]），
     * 当滑动窗口向右移动时，只要 i 还在窗口中，那么 j 一定也还在窗口中，这是 i 在 j 的左侧所保证的。
     * 因此，由于nums[j] 的存在，nums[i] 一定不会是滑动窗口中的最大值了，我们可以将 nums[i] 永久地移除。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 数组长度
        int n = nums.length;
        // 单调栈。存储的是数组中的下标。注意，这个是先进先出，应该算单调栈。
        Deque<Integer> deque = new LinkedList<Integer>();
        // 对前k个元素进行初始化
        for (int i = 0; i < k; ++i) {
            // 如果单调栈不为空， 且当前下标的值比单调栈存储的上一个下标的值大，则上一个下标出栈。
            // 循环执行，将所有的值小的坐标都移出栈
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // 定义返回数组
        int[] ans = new int[n - k + 1];
        // 最顶部的是最大的值
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 和上面的作用一样，将值小的坐标出栈
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 将下标超过k的出栈
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 最上面的元素即为所求
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}
