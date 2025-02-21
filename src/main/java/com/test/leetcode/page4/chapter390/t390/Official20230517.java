package com.test.leetcode.page4.chapter390.t390;

/**
 * @ClassName: Official20230517
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/17 09:05
 * @Version: 1.0
 */
public class Official20230517 {


    public int lastRemaining(int n) {
        // 不论删除多少轮，都是等差数列
        // 每次删除之后的首元素
        int a1 = 1;
        // k 删除轮数,cnt删除之后剩余的元素数,step是等差数列的的公差
        // 刚开始删除了0轮，cnt就是n，公差是1
        int k = 0, cnt = n, step = 1;
        // 剩余的元素数如果大于1就继续处理
        while (cnt > 1) {
            if (k % 2 == 0) {
                // 正向
                // 正向删除的时候，a1只和step有关系
                a1 = a1 + step;
            } else {
                // 反向
                // 反向删除的时候，如果cnt能被2整除，说明剩余的元素数是偶数，则a1不变，否则为a1 + step
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            // 轮数+1
            k++;
            // 每删除一轮，剩余元素数为原来的一半(向下取整)
            cnt = cnt >> 1;
            // 没删除一轮，公差是上一轮公差的2倍
            step = step << 1;
        }
        return a1;
    }
}
