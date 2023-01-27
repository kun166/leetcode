package com.test.leetcode.page2.chapter120.t120;

import java.util.List;

/**
 * @ClassName: Solution20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 9:45
 * @Version: 1.0
 */
public class Solution20230127 {

    /**
     * 注意观察规律
     * 1、当前行的第0个位置，只能有上一层的第0个位置得出
     * 2、当前行的最后一个位置n，只能有上一层的第n-1个位置得出
     * 3、其余位置n有上一层的n及n-1中小的位置得出
     * 还有一个小技巧，就是从后向前计算
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[] array = new int[length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    array[j] = triangle.get(i).get(j) + array[j - 1];
                } else {
                    array[j] = triangle.get(i).get(j) + Math.min(array[j], array[j - 1]);
                }
            }
            array[0] += triangle.get(i).get(0);
        }
        for (int i = 0; i < length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
}
