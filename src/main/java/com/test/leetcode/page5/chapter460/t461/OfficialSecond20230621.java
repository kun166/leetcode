package com.test.leetcode.page5.chapter460.t461;

/**
 * @ClassName: OfficialSecond20230621
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/21 16:42
 * @Version: 1.0
 */
public class OfficialSecond20230621 {

    /**
     * 呃，这个确实也是好写法啊
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
