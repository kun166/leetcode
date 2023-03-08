package com.test.leetcode.page3.chapter230.t231;

/**
 * @ClassName: OfficialFirst20230308
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/8 09:42
 * @Version: 1.0
 */
public class OfficialFirst20230308 {

    /**
     * 方法一：二进制表示
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


}
