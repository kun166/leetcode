package com.test.leetcode.page5.chapter440.t440;

import org.junit.Test;

/**
 * @ClassName: Official20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/9 10:55
 * @Version: 1.0
 */
public class Official20230609 {

    @Test
    public void test() {
        System.out.println(getSteps(1, 200));
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }


    /**
     * 查找以curr为根节点的子树下面有多个节点
     *
     * @param curr 当前根节点
     * @param n
     * @return
     */
    public int getSteps(int curr, long n) {
        int steps = 0;
        long first = curr;
        long last = curr;
        while (first <= n) {
            // +1的原因是first和last都包含
            steps += Math.min(last, n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return steps;
    }
}
