package com.test.leetcode.page3.chapter250.t254;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SolutionFirst20230316
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/16 19:24
 * @Version: 1.0
 */
public class SolutionFirst20230316 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(getFactors(32)));
    }

    /**
     * 唉，这种方式好像做不出来……
     *
     * @param n
     * @return
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = getFactorList(n);
        if (list.size() < 2) {
            return ans;
        }
        ans.add(list);
        int size = list.size();
        int step = 2;
        while (step < size) {
            for (int i = 0; i <= size - step; i++) {
                add(ans, list, i, step);
            }
            step++;
        }
        return ans;
    }

    public void add(List<List<Integer>> ans, List<Integer> list, int index, int step) {
        if (index > 0 && list.get(index - 1) == list.get(index + step - 1)) {
            return;
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            l.add(list.get(i));
        }
        int number = 1;
        for (int i = 0; i < step; i++) {
            number *= list.get(index + i);
        }
        l.add(number);
        for (int i = index + step; i < list.size(); i++) {
            l.add(list.get(i));
        }
        ans.add(l);
    }

    public List<Integer> getFactorList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; ) {
            if (n % i == 0) {
                list.add(i);
                n /= i;
            } else {
                if (n < i * i) {
                    list.add(n);
                    n = 1;
                }
                i++;
            }
        }
        return list;
    }
}
