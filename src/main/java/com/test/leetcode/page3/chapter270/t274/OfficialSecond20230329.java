package com.test.leetcode.page3.chapter270.t274;

/**
 * @ClassName: OfficialSecond20230329
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/29 09:12
 * @Version: 1.0
 */
public class OfficialSecond20230329 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了52.85%的用户
     * 通过测试用例：81 / 81
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

}
