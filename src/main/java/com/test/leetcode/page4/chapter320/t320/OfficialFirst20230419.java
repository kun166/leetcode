package com.test.leetcode.page4.chapter320.t320;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230419
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/19 09:56
 * @Version: 1.0
 */
public class OfficialFirst20230419 {

    /**
     * 递归+回溯
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：46.9 MB, 在所有 Java 提交中击败了38.57%的用户
     * 通过测试用例：48 / 48
     *
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length(); // keep the length of builder
        if (i == word.length()) {
            if (k != 0) builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len); // reset builder to the original state
    }
}
