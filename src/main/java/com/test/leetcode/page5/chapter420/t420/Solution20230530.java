package com.test.leetcode.page5.chapter420.t420;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 16:49
 * @Version: 1.0
 */
public class Solution20230530 {

    public int strongPasswordChecker(String password) {
        int n = password.length();
        // 三位boolean，分别表示数字，小写字母，大写字母
        boolean[] b = new boolean[3];
        List<Integer> repeatList = new ArrayList<>();
        int repeat = 1;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                b[0] = true;
            }
            if (c >= 'a' && c <= 'z') {
                b[1] = true;
            }
            if (c >= 'A' && c <= 'Z') {
                b[2] = true;
            }
            if (i > 0 && c == password.charAt(i - 1)) {
                repeat++;
            } else {
                // 判断是否大于等于3
                if (repeat >= 3) {
                    repeatList.add(repeat);
                }
                repeat = 1;
            }
        }
        int ans = 0;
        if (n >= 6 && n <= 20 && b[0] && b[1] && b[2] && repeatList.isEmpty()) {
            return ans;
        }
        // 先计算数字，小写字母和大写字母不符合的次数
        int unMatch = 0;
        for (int i = 0; i < 3; i++) {
            if (!b[i]) {
                unMatch++;
            }
        }
        if (n < 6) {
            return Math.max(Math.max(6 - n, unMatch), repeatList.size());
        }
        // 求最大值了
        if (n > 20) {
            // 可以修改，也可以减少加修改
            // 修改一个，等于减少三个
            // 太难，算了放弃了
        } else {
            // 只剩下修改了。
            int fix = 0;
            for (int i : repeatList) {
                fix += i / 3;
            }
            return Math.max(unMatch, fix);
        }
        return ans;
    }
}
