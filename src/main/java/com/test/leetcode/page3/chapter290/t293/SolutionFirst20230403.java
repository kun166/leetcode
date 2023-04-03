package com.test.leetcode.page3.chapter290.t293;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SolutionFirst20230403
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/3 17:15
 * @Version: 1.0
 */
public class SolutionFirst20230403 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了25.32%的用户
     * 通过测试用例：24 / 24
     *
     * @param currentState
     * @return
     */
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans = new ArrayList<>();
        char[] array = currentState.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == '+' && array[i - 1] == '+') {
                array[i] = array[i - 1] = '-';
                ans.add(new String(array));
                array[i] = array[i - 1] = '+';
            }
        }
        return ans;
    }
}
