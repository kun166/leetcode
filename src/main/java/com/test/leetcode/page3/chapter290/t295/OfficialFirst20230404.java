package com.test.leetcode.page3.chapter290.t295;

import java.util.PriorityQueue;

/**
 * @ClassName: Official20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 10:10
 * @Version: 1.0
 */
public class OfficialFirst20230404 {

    /**
     * 方法一：优先队列
     */
    class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        public MedianFinder() {
            // 从大到小排列，poll会获取最大值
            queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
            // 从小到大排列，poll会获取最小值
            queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num <= queMin.peek()) {
                queMin.offer(num);
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                if (queMax.size() > queMin.size()) {
                    queMin.offer(queMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            }
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }
}
