package com.test.leetcode.page2.chapter170.t179;

import java.util.Arrays;

/**
 * @ClassName: Official20230214
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/14 11:34
 * @Version: 1.0
 */
public class Official20230214 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        // 注意，这个是倒叙排序，大的在前面
        Arrays.sort(numsArr, (x, y) -> {
            // 精髓都在这里面了
            // sx是x的向上取整的10的n次幂，n是x的位数+1
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            // xy是y的向上取整的10的m次幂,m是y的位数+1
            while (sy <= y) {
                sy *= 10;
            }
            // 倒序排列
            return (int) (-sy * x - y + sx * y + x);
        });

        // 如果最大的值是0，则直接返回0了
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
