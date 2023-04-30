package com.test.leetcode.page4.chapter320.t320;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230419
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/19 09:16
 * @Version: 1.0
 */
public class Solution20230419 {

    /**
     * 执行用时：32 ms, 在所有 Java 提交中击败了5.71%的用户
     * 内存消耗：47.6 MB, 在所有 Java 提交中击败了17.14%的用户
     * 通过测试用例：48 / 48
     *
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        // 先初始化1的时候
        list.add("1");
        list.add(String.valueOf(word.charAt(0)));
        int n = word.length();
        for (int i = 1; i < n; i++) {
            List<String> second = new ArrayList<>();
            for (String str : list) {
                //取到list里的每个字符串。对字符串进行处理。有两种处理方式,1--尾部跟数字，2--尾部跟字母
                // 1--尾部跟数字
                // 取最后一位，看是数字还是字母
                char c = str.charAt(str.length() - 1);
                if (Character.isDigit(c)) {
                    // 如果尾部是数字，也不会超过19，所以不用考虑尾部是2位数进位的情况
                    second.add(str.substring(0, str.length() - 1) + (c - '0' + 1));
                } else {
                    second.add(str + 1);
                }
                // 2--尾部直接跟字母
                second.add(str + word.charAt(i));
            }
            list = second;
        }
        return list;
    }

}
