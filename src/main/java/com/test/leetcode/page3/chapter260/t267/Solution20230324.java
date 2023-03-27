package com.test.leetcode.page3.chapter260.t267;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Solution20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 17:54
 * @Version: 1.0
 */
public class Solution20230324 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generatePalindromes("a")));
    }

    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 1) {
            ans.add(s);
            return ans;
        }
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        int count = 0;
        for (int number : array) {
            if (number % 2 != 0) {
                count++;
            }
        }
        if (count > 1) {
            return ans;
        }
        char[] charArray = new char[s.length()];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            // 中间的
            if (array[i] % 2 != 0) {
                charArray[s.length() / 2] = (char) (i + 'a');
            }
            int c = array[i] / 2;
            for (int j = 0; j < c; j++) {
                charArray[index] = (char) (i + 'a');
                charArray[s.length() - 1 - index] = (char) (i + 'a');
                index++;
            }
        }
        Set<String> set = new HashSet<>();
        dfs(ans, charArray, 0, set);
        return ans;
    }

    public void dfs(List<String> ans, char[] charArray, int index, Set<String> set) {
        if (index >= charArray.length / 2) {
            return;
        }
        for (int i = index; i < charArray.length / 2; i++) {
            // 换前面的
            char c = charArray[index];
            charArray[index] = charArray[i];
            charArray[i] = c;
            // 换后面的
            charArray[charArray.length - 1 - index] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = c;
            String str = new String(charArray);
            if (!set.contains(str)) {
                ans.add(str);
                set.add(str);
            }
            dfs(ans, charArray, index + 1, set);
            // 还原回来
            charArray[i] = charArray[index];
            charArray[index] = c;
            charArray[charArray.length - 1 - i] = charArray[charArray.length - 1 - index];
            charArray[charArray.length - 1 - index] = c;
        }

    }
}
