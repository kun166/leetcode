package com.test.leetcode.page3.chapter240.t246;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Other20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 09:22
 * @Version: 1.0
 */
public class Other20230314 {

    /**
     * 这个写法确实比我的好。
     * 双指针大法
     *
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');//特别注意0如果在开头或者末尾一定不符合题意
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (map.get(num.charAt(left)) == null || map.get(num.charAt(right)) == null) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
