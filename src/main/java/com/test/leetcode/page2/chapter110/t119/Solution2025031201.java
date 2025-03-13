package com.test.leetcode.page2.chapter110.t119;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025031201
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 16:35
 * @Version: 1.0
 */
public class Solution2025031201 {

    /**
     * O(rowIndex) 空间复杂度容易，但是一次性生成,好像真不会啊……
     * <p>
     * 1ms 击败67.88%
     * 40.61 MB 击败7.00%
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            /**
             * 这行代码挪到for循环下面执行,代码会简单很多(调试for循环头大)……
             */
            ans.push(1);
            for (int j = 1; j < i; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }
        return ans;
    }
}
