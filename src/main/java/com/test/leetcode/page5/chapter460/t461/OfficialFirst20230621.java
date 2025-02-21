package com.test.leetcode.page5.chapter460.t461;

/**
 * @ClassName: OfficialFirst20230621
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/21 16:40
 * @Version: 1.0
 */
public class OfficialFirst20230621 {

    /**
     * 感觉x^y就比较骚啊
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
