package com.test.leetcode.chapter10.t17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 11:01
 */
public class Solution {

    Map<Character, char[]> map = new HashMap<>();

    {
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 's', 'y', 'z'});
    }

    @Test
    public void test() {
        String str = "22";
        int length = str.length();
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                list.addAll(convert(new StringBuilder(), str.charAt(0)));
            } else {
                List<StringBuilder> copy = list;
                list = new ArrayList<>();
                for (StringBuilder s : copy) {
                    list.addAll(convert(s, str.charAt(i)));
                }
            }
        }


        for (StringBuilder s : list) {
            System.out.println(s.toString());
        }
    }


    public List<StringBuilder> convert(StringBuilder sb, char number) {
        List<StringBuilder> list = new ArrayList<>();
        char[] array = map.get(number);
        int l = array.length;
        for (int i = 0; i < l; i++) {
            StringBuilder stringBuilder = new StringBuilder(sb);
            stringBuilder.append(array[i]);
            list.add(stringBuilder);
        }
        return list;
    }

    @Test
    public void recursionTest() {
        String str = "22";
        List<StringBuilder> list = recursionConvert(str.length() - 1, str);
        for (StringBuilder s : list) {
            System.out.println(s.toString());
        }
    }

    /**
     * 递归算法
     *
     * @param index
     * @param nummber
     * @return
     */
    public List<StringBuilder> recursionConvert(int index, String nummber) {
        List<StringBuilder> list = new ArrayList<>();
        if (index == 0) {
            char[] ca = map.get(nummber.charAt(0));
            int l = ca.length;
            for (int i = 0; i < l; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(ca[i]);
                list.add(sb);
            }
            return list;
        }
        List<StringBuilder> pl = recursionConvert(index - 1, nummber);
        char[] ca = map.get(nummber.charAt(index));
        int l = ca.length;
        for (StringBuilder s : pl) {
            for (int i = 0; i < l; i++) {
                StringBuilder ns = new StringBuilder(s);
                ns.append(ca[i]);
                list.add(ns);
            }
        }
        return list;
    }

    @Test
    public void officialTest() {
        List<String> list = new ArrayList<>();
        recursionConvert(list, "23", 0, new StringBuilder());
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 官网递归重新写一遍
     *
     * @return
     */
    public void recursionConvert(List<String> list, String str, int index, StringBuilder result) {
        if (index == str.length()) {
            list.add(result.toString());
            return;
        }
        char[] ca = map.get(str.charAt(index));
        int length = ca.length;
        for (int i = 0; i < length; i++) {
            result.append(ca[i]);
            recursionConvert(list, str, index + 1, result);
            result.deleteCharAt(index);
        }
    }

}
