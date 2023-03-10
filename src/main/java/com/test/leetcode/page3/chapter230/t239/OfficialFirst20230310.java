package com.test.leetcode.page3.chapter230.t239;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: OfficialFirst20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 08:27
 * @Version: 1.0
 */
public class OfficialFirst20230310 {

    /**
     * 方法一：优先队列
     * 呃，这种方式也比TreeMap快啊
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                // 长度为2的整形数组。下标0记录值，下标1记录在原数组的下标
                // 如果值不同，大的在上面，如果值相同，坐标大的在上面。
                // 即先比较值，再比较坐标
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        // 初始化前k个元素
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        // 返回数组
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // 如果最大元素的下标和当前坐标的差值超过了k，则移除。
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

}
