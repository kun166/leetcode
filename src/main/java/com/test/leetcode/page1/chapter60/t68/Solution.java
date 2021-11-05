package com.test.leetcode.page1.chapter60.t68;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 19:30
 */
public class Solution {

    @Test
    public void test() {
        List<String> list = fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        fullJustify(list, words, maxWidth);
        return list;
    }

    public List<String> fullJustify(List<String> list, String[] words, int maxWidth) {
        int width = 0;
        int start = 0, end = 0;
        while (end < words.length) {
            width += words[end].length();
            if (end == words.length - 1) {
                list.add(fullJustify(words, start, end, maxWidth, width, true));
                break;
            }
            if (width + words[end + 1].length() + end - start + 1 > maxWidth) {
                list.add(fullJustify(words, start, end, maxWidth, width, false));
                start = end + 1;
                width = 0;
            }
            end++;
        }
        return list;
    }

    public String fullJustify(String[] words, int start, int end, int maxWidth, int width, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        if (lastLine) {
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);
                sb.append(" ");
            }
            if (maxWidth == width + end - start) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // 最后补齐空格
                int size = maxWidth - 1 - (width + end - start);
                for (int i = 0; i < size; i++) {
                    sb.append(" ");
                }
            }
        } else {
            int dif = end - start;
            if (dif == 0) {
                sb.append(words[start]);
                for (int i = 0; i < maxWidth - width; i++) {
                    sb.append(" ");
                }
            } else {
                int blank = (maxWidth - width) / dif;
                int more = maxWidth - width - dif * blank;
                for (int i = start; i <= end; i++) {
                    sb.append(words[i]);
                    if (i == end)
                        continue;
                    // 补齐空格
                    for (int j = 0; j < blank; j++) {
                        sb.append(" ");
                    }
                    if (more > 0) {
                        sb.append(" ");
                        more--;
                    }
                }
            }
        }
        return sb.toString();
    }
}
