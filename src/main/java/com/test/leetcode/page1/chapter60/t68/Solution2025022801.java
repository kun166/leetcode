package com.test.leetcode.page1.chapter60.t68;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025022801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 09:13
 * @Version: 1.0
 */
public class Solution2025022801 {

    /**
     * 困难题……尝试下吧
     *
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        // 双指针法吧
        int left = 0, right;
        while (true) {
            right = left;
            int curLength = words[left].length();
            // 多加一个=,能保证right一定是不符合的？
            /**
             * 这个地方是一个绝坑,几乎难以发现
             * curLength 是没+1之前的right算出来的,然后又在+1之后和maxWidth对比没成功
             * 这说明了什么？说明了right-2的那个位置才是符合要求的……
             *
             * 这个while的代码,一定要仔细仔细的体会啊
             *
             * while (++right < words.length && curLength <= maxWidth) {
             */
            while (curLength <= maxWidth && ++right < words.length) {
                // 这个地方需要注意，如果有n个单词,实际长度是n个单词长度+(n-1)个空格
                /**
                 * 嗯，死循环了……
                 * curLength += words[right].length() + 1;
                 */
                curLength += words[right].length() + 1;
            }

            if (right == words.length) {
                // 说明是最后一行
                StringBuilder builder = new StringBuilder();
                builder.append(words[left]);
                curLength = words[left].length();

                for (int i = left + 1; i < right; i++) {
                    builder.append(' ').append(words[i]);
                    curLength += words[i].length() + 1;
                }
                fillBlank(builder, maxWidth - curLength);
                ans.add(builder.toString());
                break;
            }

            // 不是最后一行
            // 剩余空格数
            /**
             * 这个地方的curLength包含了right的长度,所以要加回来
             * int remain = maxWidth - curLength
             */
            int remain = maxWidth - curLength + (words[right].length() + 1);
            /**
             * 这个地方漏了,就是right-left==1的时候，即只有一个单词的时候
             */
            if (right - left == 1) {
                StringBuilder builder = new StringBuilder();
                builder.append(words[left]);
                fillBlank(builder, remain);
                ans.add(builder.toString());
                /**
                 * 呃，这行漏了，又死循环了
                 */
                left = right;
                continue;
            }
            // 每个单词之间多加的空格数。left算，right不算，所以一共right-left个单词,之间的空隙再减1
            // 后面的+1是因为curLength里面已经计算了多加一次空格了
            int every = remain / (right - left - 1) + 1;
            // 每个间隙添加every个空格之后,剩余的空格数
            remain = remain % (right - left - 1);
            StringBuilder builder = new StringBuilder();
            builder.append(words[left]);
            for (int i = left + 1; i < right; i++) {
                fillBlank(builder, every + (--remain >= 0 ? 1 : 0));
                builder.append(words[i]);
            }
            ans.add(builder.toString());

            left = right;
        }
        return ans;
    }

    void fillBlank(StringBuilder builder, int count) {
        while (--count >= 0) {
            builder.append(' ');
        }
    }
}
