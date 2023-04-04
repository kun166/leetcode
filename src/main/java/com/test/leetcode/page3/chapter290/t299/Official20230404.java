package com.test.leetcode.page3.chapter290.t299;

/**
 * @ClassName: Official20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 16:00
 * @Version: 1.0
 */
public class Official20230404 {

    /**
     * 牛逼，大神
     * 执行用时：4 ms, 在所有 Java 提交中击败了86.55%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了35.93%的用户
     * 通过测试用例：152 / 152
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
