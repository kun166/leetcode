package com.test.leetcode.page4.chapter330.t336;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20230427
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/27 09:08
 * @Version: 1.0
 */
public class Solution20230427 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Integer blankIndex = -1;
        Map<String, Integer> map = new HashMap<>();
        // 遍历数组，记录翻转后的坐标
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                blankIndex = i;
                continue;
            }
            map.put(revers(words[i]), i);
        }

        return ans;
    }

    public boolean palindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public String revers(String str) {
        char[] array = str.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            char c = array[left];
            array[left] = array[right];
            array[right] = c;
        }
        return new String(array);
    }

}
