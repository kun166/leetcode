package com.test.leetcode.page1.chapter30.t32;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-27 15:14
 */
public class Solution20201027 {

    @Test
    public void test() {
        System.out.println(longestValidParentheses("(()"));
    }

    public int longestValidParentheses(String s) {
        int length = s.length();
        //以key,value的形势，记录从key到value是匹配的。只记录多层()的
        Map<Integer, Integer> map = new HashMap<>();
        //初始化匹配的数据
        for (int i = 0; i < length - 1; i++) {
            // 先寻找()的
            if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                //向外扩展
                record(s, map, i, i + 1);
            }
        }
        //计算最大值
        int maxLength = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int l = entry.getKey() - entry.getValue() + 1;
            if (maxLength < l) {
                maxLength = l;
            }
        }
        return maxLength;
    }

    public void record(String s, Map<Integer, Integer> map, int start, int end) {
        int length = s.length(), preStart = start;
        while (start > 0 && end < length - 1 && s.charAt(start - 1) == '(' && s.charAt(end + 1) == ')') {
            start--;
            end++;
        }
        while (map.containsKey(start - 1)) {
            start = map.get(start - 1);
        }
        if (start == preStart) {
            map.put(end, start);
            return;
        }
        record(s, map, start, end);
    }

}
