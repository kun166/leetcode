package com.test.leetcode.page2.chapter190.t190;

/**
 * @ClassName: OfficialSecond20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 17:08
 * @Version: 1.0
 */
public class OfficialSecond20230215 {
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBits(int n) {
        n = n >>> 8 & M8 | (n & M8) << 8;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 1 & M1 | (n & M1) << 1;
        return n >>> 16 | n << 16;
    }
}
