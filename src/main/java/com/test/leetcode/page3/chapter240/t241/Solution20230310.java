package com.test.leetcode.page3.chapter240.t241;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 10:52
 * @Version: 1.0
 */
public class Solution20230310 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(diffWaysToCompute("2*3-4*5")));
    }

    /**
     * 这个感觉只能是递归回溯
     * <p>
     * 唉，这解法是错误的……
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        List<Character> operatorList = new ArrayList<>();
        int number = 0;
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else {
                operatorList.add(c);
                numberList.add(number);
                number = 0;
            }
        }
        numberList.add(number);
        diffWaysToCompute(ans, numberList, operatorList, 0, numberList.get(0));
        return ans;
    }


    public void diffWaysToCompute(List<Integer> list, List<Integer> numberList, List<Character> operatorList, int index, int number) {
        if (index == operatorList.size()) {
            list.add(number);
            return;
        }
        int current = 0, pre;
        for (int i = index; i < operatorList.size(); i++) {
            pre = number;
            if (i == index) {
                current = numberList.get(i + 1);
            } else {
                char c = operatorList.get(i);
                if (c == '+') {
                    current += numberList.get(i + 1);
                } else if (c == '-') {
                    current -= numberList.get(i + 1);
                } else {
                    current *= numberList.get(i + 1);
                }
            }
            char c = operatorList.get(index);
            if (c == '+') {
                pre += current;
            } else if (c == '-') {
                pre -= current;
            } else {
                pre *= current;
            }

            diffWaysToCompute(list, numberList, operatorList, i + 1, pre);
        }
    }


}
