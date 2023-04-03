package com.test.leetcode.page3.chapter290.t292;

/**
 * @ClassName: SolutionSecond20230403
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/3 16:53
 * @Version: 1.0
 */
public class SolutionSecond20230403 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了21%的用户
     * 通过测试用例：60 / 60
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
