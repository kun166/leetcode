package com.test.leetcode.page3.chapter260.t264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @ClassName: OfficialFirst20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 09:13
 * @Version: 1.0
 */
public class OfficialFirst20230324 {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        // 需要循环n次，找到这个值
        for (int i = 0; i < n; i++) {
            // 堆顶元素，这个元素是最小值，也即排序第i+1的那个元素
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                // 下面就比较巧妙了，拿到这个i+1的值之后，怎么生成其它的数呢？分别乘以2,3,5再排序
                long next = curr * factor;
                if (seen.add(next)) {
                    // 通过set去重，666
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
