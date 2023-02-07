package com.test.leetcode.page2.chapter150.t151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230207
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/7 10:08
 * @Version: 1.0
 */
public class OfficialFirst20230207 {

    /**
     * 使用语言特性
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        // split还可以这么用啊？
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
