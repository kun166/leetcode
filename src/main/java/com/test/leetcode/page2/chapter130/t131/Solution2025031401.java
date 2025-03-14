package com.test.leetcode.page2.chapter130.t131;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025031401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/14 14:18
 * @Version: 1.0
 */
public class Solution2025031401 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(partition("cdd")));
    }

    /**
     * 呃，这题是一个中等题？这难道不是一个困难题么
     * 28ms	击败5.29%
     * 69.82MB	击败5.00%
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ans = dps(s, 0, s.length());
        return ans;
    }

    public List<List<String>> dps(String s, int left, int right) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (left >= right) {
            ans.add(list);
            return ans;
        }
        if (left + 1 == right) {
            list.add(s.substring(left, right));
            ans.add(list);
            return ans;
        }
        int length = right - left;
        for (int i = 1; i <= length; i++) {
            if (match(s, left, left + i - 1)) {
                /**
                 * 这个地方明显有问题……,会不停的迭代,可以dp
                 */
                List<List<String>> rightAns = dps(s, left + i, right);
                for (List<String> l : rightAns) {
                    l.add(0, s.substring(left, left + i));
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    public boolean match(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
