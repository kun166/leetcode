package com.test.leetcode.page1.chapter90.t93;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 14:31
 * @Version: 1.0
 */
public class Solution2025030701 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(restoreIpAddresses("101023")));
    }

    /**
     * 这题感觉得用递归-回溯
     * 2ms 击败74.77%
     * 41.13MB 击败99.45%
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    public void backtrack(String s, List<String> ans, StringBuilder builder, int index, int pointCount) {
        if (index == s.length() && pointCount == 4) {
            ans.add(builder.deleteCharAt(builder.length() - 1).toString());
            return;
        }
        /**
         * 嗯，这个地方少了一个剪枝pointCount > 4
         */
        if (index >= s.length()) {
            return;
        }
        // 选择一个字符
        int length = builder.length();
        builder.append(s.charAt(index)).append('.');
        backtrack(s, ans, builder, index + 1, pointCount + 1);
        if (s.charAt(index) != '0') {
            // 选择两个字符
            if (index + 1 < s.length()) {
                builder.deleteCharAt(builder.length() - 1);
                builder.append(s.charAt(index + 1)).append('.');
                backtrack(s, ans, builder, index + 2, pointCount + 1);
            }

            // 选择三个字符,得保证三个字符<=255
            if (index + 2 < s.length() && ((s.charAt(index) - '0') * 100 + (s.charAt(index + 1) - '0') * 10 + (s.charAt(index + 2) - '0') <= 255)) {
                builder.deleteCharAt(builder.length() - 1);
                builder.append(s.charAt(index + 2)).append('.');
                backtrack(s, ans, builder, index + 3, pointCount + 1);
            }
        }

        /**
         * 这就保证了
         * 每一次{@link Solution2025030701#backtrack(String, List, StringBuilder, int, int)}
         * 执行完之后,
         * builder都和执行该递归方法之前一致
         */
        builder.delete(length, builder.length());
    }

}
