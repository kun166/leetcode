package com.test.leetcode.page1.chapter60.t68;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221120
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/20 8:12
 * @Version: 1.0
 */
public class Solution20221120 {

    /**
     * 1、尽可能多的放置单词
     * 2、左侧空格数应该多余右侧
     * 3、最后一行不压缩
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0, right = 0, n = words.length, currentLength = 0;
        List<String> ans = new ArrayList<>();
        while (right < n) {
            int length = currentLength + (right != left ? 1 : 0) + words[right].length();
            if (length <= maxWidth) {
                // 加上下一单词，也不会超过maxWidth
                currentLength = length;
                right++;
            } else {
                // 超过了，得处理
                ans.add(fullJustify(words, left, right - 1, currentLength, maxWidth));
                left = right;
                currentLength = 0;
            }
        }
        // 循环结束，处理最后一次
        StringBuilder builder = new StringBuilder(words[left++]);
        while (left < n) {
            builder.append(' ');
            builder.append(words[left++]);
        }
        int builderLength = builder.length();
        while (builderLength < maxWidth) {
            builder.append(' ');
            builderLength++;
        }
        ans.add(builder.toString());
        return ans;
    }

    public String fullJustify(String[] words, int left, int right, int currentLength, int maxWidth) {
        if (left == right) {
            // 一个单词的时候
            StringBuilder builder = new StringBuilder(words[left]);
            int builderLength = builder.length();
            while (builderLength < maxWidth) {
                builder.append(' ');
                builderLength++;
            }
            return builder.toString();
        }
        // 确切的说，这是单词之间的空隙数量
        int wordCount = right - left;
        // 两个单词之间的空格数
        int whiteCount = 1 + (maxWidth - currentLength) / wordCount;
        // 平均分配之后还剩余的空格数
        int moreWhiteCount = (maxWidth - currentLength) % wordCount;
        StringBuilder builder = new StringBuilder(words[left++]);
        while (left <= right) {
            int wc = whiteCount;
            while (wc > 0) {
                builder.append(' ');
                wc--;
            }
            if (moreWhiteCount > 0) {
                builder.append(' ');
                moreWhiteCount--;
            }
            builder.append(words[left++]);
        }
        return builder.toString();
    }
}
