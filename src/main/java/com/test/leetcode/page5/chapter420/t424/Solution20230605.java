package com.test.leetcode.page5.chapter420.t424;

import com.sun.xml.internal.xsom.XSUnionSimpleType;
import org.junit.Test;

/**
 * @ClassName: Solution20230605
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/5 14:32
 * @Version: 1.0
 */
public class Solution20230605 {

    @Test
    public void test() {
        System.out.println(characterReplacement("EQQEJDOBDPDPFPEIAQLQGDNIRDDGEHJIORMJPKGPLCPDFMIGHJNIIRSDSBRNJNROBALNSHCRFBASTLRMENCCIBJLGAITBFCSMPRO", 2));
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了99.07%的用户
     * 内存消耗：40.9 MB, 在所有 Java 提交中击败了76.49%的用户
     * 通过测试用例：39 / 39
     * <p>
     * 前后指针
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        // 返回结果
        int ans = 1;
        int n = s.length();
        // 字符数组
        char[] array = s.toCharArray();
        // 记录字符出现的次数
        int[] count = new int[26];
        count[array[0] - 'A']++;
        int left = 0, right = 1;
        // 记录最频繁字符串出现次数
        int maxCount = 1;
        while (right < n) {
            count[array[right] - 'A']++;
            // 这个maxCount有一个隐含的含义，它只增不减。因为比它小的数，一定不会比它替换k个字符串之后更长
            maxCount = Math.max(maxCount, count[array[right] - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[array[left] - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
