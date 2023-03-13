package com.test.leetcode.page2.chapter150.t158;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Solution
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 14:51
 * @Version: 1.0
 */
public class Solution extends Reader4 {

    private Queue<Character> queue = new LinkedList<>();

    /**
     * 执行用时：
     * 1 ms, 在所有 Java 提交中击败了18.18%的用户
     * 内存消耗：
     * 39.9 MB, 在所有 Java 提交中击败了63.64%的用户
     *
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int point = 0;
        while (n > 0 && !queue.isEmpty()) {
            buf[point++] = queue.poll();
            n--;
        }
        if (n == 0) {
            return point;
        }
        // 通过Reader4读取
        int length = 0, i = 0;
        char[] buffer = new char[4];
        while (n > 0 && (length = read4(buffer)) > 0) {
            for (i = 0; i < length && n > 0; i++) {
                buf[point++] = buffer[i];
                n--;
            }
        }
        while (n == 0 && i < length) {
            queue.offer(buffer[i++]);
        }
        return point;
    }
}

class Reader4 {
    int read4(char[] buf4) {
        return 0;
    }
}
