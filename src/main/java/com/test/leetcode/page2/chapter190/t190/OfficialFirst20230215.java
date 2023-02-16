package com.test.leetcode.page2.chapter190.t190;

/**
 * @ClassName: OfficialFirst20230215
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/15 16:47
 * @Version: 1.0
 */
public class OfficialFirst20230215 {

    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
