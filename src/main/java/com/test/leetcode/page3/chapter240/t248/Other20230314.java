package com.test.leetcode.page3.chapter240.t248;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Other20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 15:08
 * @Version: 1.0
 */
public class Other20230314 {

    public int strobogrammaticInRange(String low, String high) {
        int sum = 0;
        // high的长度
        int m = high.length();
        // low的长度
        int n = low.length();
        // 长度差
        int d = m - n;
        if (d == 0) {
            List<String> res = helper(n, n);
            for (String s : res) {
                if (Long.parseLong(s) >= Long.parseLong(low) && Long.parseLong(s) <= Long.parseLong(high)) sum++;
            }
            return sum;
        } else {
            for (int i = m; i >= n; i--) {
                List<String> res = helper(i, i);
                for (String s : res) {
                    if (Long.parseLong(s) >= Long.parseLong(low) && Long.parseLong(s) <= Long.parseLong(high)) sum++;
                }
            }

        }
        return sum;
    }


    // n表示，当前循环中，求得字符串长度； m表示题目中要求的字符串长度
    public List<String> helper(int n, int m) {
        // 第一步：判断输入或者状态是否合法
        if (n < 0 || m < 0 || n > m) {
            throw new IllegalArgumentException("invalid input");
        }
        // 第二步：判断递归是否应当结束
        if (n == 0)
            return new ArrayList<>(Arrays.asList(""));
        if (n == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        // 第三步：缩小问题规模
        List<String> list = helper(n - 2, m);
        // 第四步：整合结果
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if (n != m) res.add("0" + s + "0");
            // n=m时，表示最外层处理。
            // 例如：原始需求n=m=2, '00'不合法
            // 若原始需求n=m=4, 内层循环n=2,m=4,'00';最外层循环，n=m=4时，'1001'
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }


        return res;
    }

}
