package com.test.leetcode.page5.chapter460.t464;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Official20230625
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/25 09:56
 * @Version: 1.0
 */
public class Official20230625 {

    Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 如果数的累加合也不超过desiredTotal，则一定不会赢
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    /**
     * @param maxChoosableInteger 可选的最大数
     * @param usedNumbers         已经用掉的数字集合，因为最大值20，这里用32位的Integer记录了使用了哪些数字了
     * @param desiredTotal        目标值
     * @param currentTotal        当前已经使用的数字集合的累加合
     * @return
     */
    public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if (!memo.containsKey(usedNumbers)) {
            boolean res = false;
            for (int i = 0; i < maxChoosableInteger; i++) {
                if (((usedNumbers >> i) & 1) == 0) {
                    if (i + 1 + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumbers, res);
        }
        return memo.get(usedNumbers);
    }

}
