package com.test.leetcode.page2.chapter110.t119;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution2025031203
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 17:09
 * @Version: 1.0
 */
public class Solution2025031203 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(getRow(5)));
    }

    /**
     * 0ms 击败100.00%
     * 40.29MB 击败77.06%
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] array = new Integer[rowIndex + 1];
        array[0] = 1;
        Integer pre, curr;
        for (int i = 0; i <= rowIndex; i++) {
            pre = 1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    array[j] = 1;
                } else {
                    curr = array[j];
                    array[j] += pre;
                    pre = curr;
                }
            }
        }
        return Arrays.asList(array);
    }
}
