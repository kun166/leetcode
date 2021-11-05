package com.test.leetcode.page1.chapter0.t3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-10 15:05
 */
public class SolutionSecond {

    @Test
    public void test() {
        System.out.println(getLongestStrTwo("abcabcbb"));
    }


    public int getLongestStr(String s) {
        int length = s.length();
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                for (int j = left; j <= i; j++) {
                    set.remove(s.charAt(j));
                    if (s.charAt(j) == c) {
                        left = j;
                        break;
                    }
                }
                max = max > i - left ? max : i - left;
            }
        }
        return max;
    }

    public int getLongestStrTwo(String s) {
        int length = s.length();
        int left = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            while (left < length && !set.contains(s.charAt(left))) {
                set.add(s.charAt(left));
                left++;
            }
            set.remove(s.charAt(i));
            max = max > left - i ? max : left - i;
        }
        return max;
    }
}
