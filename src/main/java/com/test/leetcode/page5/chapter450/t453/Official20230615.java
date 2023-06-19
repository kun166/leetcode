package com.test.leetcode.page5.chapter450.t453;

import java.util.Arrays;

/**
 * @ClassName: Official20230615
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/15 09:50
 * @Version: 1.0
 */
public class Official20230615 {

    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

}
