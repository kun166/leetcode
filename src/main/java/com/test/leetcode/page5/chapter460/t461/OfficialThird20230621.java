package com.test.leetcode.page5.chapter460.t461;

/**
 * @ClassName: OfficialThird20230621
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/21 16:43
 * @Version: 1.0
 */
public class OfficialThird20230621 {

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

}
