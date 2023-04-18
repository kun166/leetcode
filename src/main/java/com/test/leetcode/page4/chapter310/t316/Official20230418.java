package com.test.leetcode.page4.chapter310.t316;

/**
 * @ClassName: Solution20230418
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/18 08:29
 * @Version: 1.0
 */
public class Official20230418 {

    /**
     * 贪心 + 单调栈
     * <p>
     * 首先考虑一个简单的问题：给定一个字符串 s，如何去掉其中的一个字符 ch，使得得到的字符串字典序最小呢？
     * 答案是：找出最小的满足 s[i]>s[i+1] 的下标 i，并去除字符 s[i]。为了叙述方便，下文中称这样的字符为「关键字符」。
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        // 记录26个字母出现的次数
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        // 返回结果
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            // 当前字符
            char ch = s.charAt(i);
            // 当前字符还未选择
            if (!vis[ch - 'a']) {
                // 循环遍历已经选择的字符，如果字符值比当前字符值大，则进行比较删除
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    // 已选择的字符值大的，数量大于0，说明后面还有该字符
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        // 删除该字符，设置该字符未选择
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        // 说明后面已经没有该字符了，必须得选
                        break;
                    }
                }
                // 选择当前字符
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            // ch的数量-1
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

}
