package com.test.leetcode.page2.chapter130.t135;

/**
 * @ClassName: Solution2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 10:48
 * @Version: 1.0
 */
public class Solution2025031901 {

    /**
     * 分成两种:
     * 1,凸型
     * 2,凹型
     * 也可以分成
     * 1,升序
     * 2,降序
     * <p>
     * 1,升序这个好解决,就是+1就行？
     * 2,降序这个怎么解决?
     * <p>
     * 2ms	击败98.73%
     * 45.00MB	击败31.42%
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int ans = 1, curCandy = 1, n = ratings.length, length = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (length > 0) {
                    /**
                     * 需要处理降序时多发或者少发的补偿
                     */
                    if (curCandy > 1) {
                        /**
                         * 说明降序时,多发了。
                         * 注意:
                         * 1,length长度记录的是连续降序的数量少1
                         * 2,如果是多发了,连续降序的第一个孩子糖果是正确的,不能补偿减去
                         */
                        ans -= length * (curCandy - 1);
                    } else if (curCandy < 1) {
                        /**
                         * 如果是少发了,
                         * 这个时候,连续降序的第一个孩子的糖果也得给补偿上
                         */
                        ans += (length + 1) * (1 - curCandy);
                    }
                    length = 0;
                    curCandy = 1;
                }
                if (ratings[i] > ratings[i - 1])
                    // 升序,糖果直接多给一个就行了
                    curCandy++;
                else
                    // 平序,糖果给1个就好
                    curCandy = 1;
                ans += curCandy;
            } else {
                // 降序
                length++;
                ans += --curCandy;
            }
        }
        // 最后处理降序的节点
        if (length > 0) {
            if (curCandy > 1) {
                // 说明需要减去多发的糖果数
                ans -= length * (curCandy - 1);
            } else if (curCandy < 1) {
                // 说明需要加上少发的糖果数
                ans += (length + 1) * (1 - curCandy);
            }
        }
        return ans;
    }
}
