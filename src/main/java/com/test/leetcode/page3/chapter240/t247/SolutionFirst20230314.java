package com.test.leetcode.page3.chapter240.t247;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Solution20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 09:27
 * @Version: 1.0
 */
public class SolutionFirst20230314 {

    private static final Map<Character, Character> map = new HashMap() {
        {
            put('0', '0');
            put('1', '1');
            put('8', '8');
            put('6', '9');
            put('9', '6');
        }
    };

    private static final char[] array = new char[]{'0', '1', '6', '8', '9'};


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(findStrobogrammatic(1)));
    }


    /**
     * 这种方式，明显很耗时，只能说是乱撞。
     * 哈哈，果然超时了……
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        findStrobogrammatic(n, ans, new StringBuilder());
        return ans;
    }

    public void findStrobogrammatic(int n, List<String> ans, StringBuilder builder) {
        if (builder.length() > 1 && builder.charAt(0) == '0') {
            return;
        }
        if (builder.length() == n) {
            if (isStrobogrammatic(builder)) {
                ans.add(builder.toString());
            }
            return;
        }
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            findStrobogrammatic(n, ans, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


    public boolean isStrobogrammatic(StringBuilder num) {
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (num.charAt(left) != map.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
