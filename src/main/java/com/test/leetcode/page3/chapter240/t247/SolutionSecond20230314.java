package com.test.leetcode.page3.chapter240.t247;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SolutionSecond20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 09:57
 * @Version: 1.0
 */
public class SolutionSecond20230314 {

    private static final Map<Character, Character> map = new HashMap() {
        {
            put('0', '0');
            put('1', '1');
            put('8', '8');
            put('6', '9');
            put('9', '6');
        }
    };

    private static final char[] array = new char[]{'0', '1', '6', '8', '9'};


    /**
     * 可以考虑折半法，先生成一半，再根据这一半生成另一半
     * <p>
     * 执行用时：37 ms, 在所有 Java 提交中击败了14.74%的用户
     * 内存消耗：51.7 MB, 在所有 Java 提交中击败了60.00%的用户
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            // 0比较特殊，除了在n==1的时候，不能作为开头
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        }
        findStrobogrammatic(n, ans, new StringBuilder());
        return ans;
    }

    public void findStrobogrammatic(int n, List<String> ans, StringBuilder builder) {
        if (builder.length() > 0 && builder.charAt(0) == '0') {
            return;
        }
        if (builder.length() == n / 2) {
            String rightPart = getRightPart(builder);
            if (n % 2 == 0) {
                ans.add(builder + rightPart);
            } else {
                ans.add(builder + "0" + rightPart);
                ans.add(builder + "1" + rightPart);
                ans.add(builder + "8" + rightPart);
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            findStrobogrammatic(n, ans, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String getRightPart(StringBuilder builder) {
        StringBuilder b = new StringBuilder();
        for (int i = builder.length() - 1; i >= 0; i--) {
            b.append(map.get(builder.charAt(i)));
        }
        return b.toString();
    }
}
