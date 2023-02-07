package com.test.leetcode.page2.chapter150.t151;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OfficialThird20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 10:13
 * @Version: 1.0
 */
public class OfficialThird20230207 {

    /**
     * 双端队列
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 又一种双端队列的实现
        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
