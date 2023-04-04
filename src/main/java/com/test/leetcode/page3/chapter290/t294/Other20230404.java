package com.test.leetcode.page3.chapter290.t294;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Other20230404
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/4 09:27
 * @Version: 1.0
 */
public class Other20230404 {

    int n;
    Map<Long, Boolean> memo = new HashMap<>();

    public boolean canWin(String s) {
        n = s.length();
        long mask = 0;
        for (int i = 0; i < n; ++i)
            if (s.charAt(i) == '+')
                mask |= 1L << i;
        return dfs(mask);
    }

    boolean dfs(long mask) {
        if (memo.containsKey(mask))
            return memo.get(mask);
        for (int i = 1; i < n; ++i) {
            if ((mask & 1L << i) == 0 || (mask & 1L << i - 1) == 0)
                continue;
            if (dfs(mask ^ 1L << i ^ 1L << i - 1))
                continue;// 对方必胜则不选这条路
            // 对方只要有一个必败，我方选这条路则必胜
            memo.put(mask, true);
            return true;
        }
        // 我方无论选哪条路对方都必胜 或者 我方无路可选
        memo.put(mask, false);
        return false;
    }
}
