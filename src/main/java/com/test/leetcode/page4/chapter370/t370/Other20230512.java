package com.test.leetcode.page4.chapter370.t370;

/**
 * @ClassName: Other20230512
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/12 10:42
 * @Version: 1.0
 */
public class Other20230512 {

    /**
     * 这个算法的思路就是
     * 1，创建一个int res[] = new int[length]，res[i]记录从i开始向后的所有点都增加了res[i]
     * 2，对于每一个updates[j],res[updates[j][0]]增加updates[j][2],res[updates[j][1]+1]减少updates[j][2]
     * 3，通过res求累加合……
     * <p>
     * 真的是牛逼的算法啊
     *
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int res[] = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < length) {
                res[update[1] + 1] -= update[2];
            }
        }

        int change = 0;
        for (int i = 0; i < res.length; i++) {
            change += res[i];
            res[i] = change;
        }
        return res;
    }
}
