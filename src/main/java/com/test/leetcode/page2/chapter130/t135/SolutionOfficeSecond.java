package com.test.leetcode.page2.chapter130.t135;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-21 19:52
 */
public class SolutionOfficeSecond {

    public int candy(int[] ratings) {
        int n = ratings.length;
        // 总共需要的糖果数
        int ret = 1;
        // 当前递减序列的长度dec,最近的递增序列的长度inc,和前一个同学分得的糖果数量pre
        int inc = 1, dec = 0, pre = 1;
        // 遍历数组。注意是从1开始的，而不是从0
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                // 如果当前位置小朋友的分数不低于上一个位置的小朋友分数
                dec = 0;
                // 如果得分相同，则赋值为1,否则在原来的值上+1
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                // 累计
                ret += pre;
                // 增长值
                inc = pre;
            } else {
                // 当前位置小朋友的分数低于上一个位置的小朋友分数
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
