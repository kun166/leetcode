package com.test.leetcode.page2.chapter130.t131;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 16:37
 */
public class Solution {

    @Test
    public void test() {
        List<List<String>> list = partition("aab");
        System.out.println(JSON.toJSONString(list));
    }

    /**
     * 牛逼了，我以前居然写出过这么牛逼的代码。
     * 这个解法又简单，又牛逼，是我写的么
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> list = new ArrayList<>();
        partition(s, 0, list, result);
        return result;
    }

    public void partition(String s, int index, List<String> list, List<List<String>> result) {
        if (index == s.length()) {
            List<String> l = new ArrayList<>(list);
            result.add(l);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (match(s, index, i)) {
                list.add(s.substring(index, i + 1));
                partition(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 判断字符串s从start到end的子串是否是回文子
     *
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean match(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
