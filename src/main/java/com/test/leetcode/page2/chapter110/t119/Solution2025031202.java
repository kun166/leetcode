package com.test.leetcode.page2.chapter110.t119;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025031202
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 17:05
 * @Version: 1.0
 */
public class Solution2025031202 {

    /**
     * 1ms 击败67.88%
     * 40.45MB 击败36.18%
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(0, 1);
            for (int j = 1; j < i; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }
        return ans;
    }
}
