package com.test.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: FastSort
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/13 14:49
 * @Version: 1.0
 */
public class FastSort {

    @Test
    public void test() {
        int[] array = {5, 4, 1, 2, 0, 0, 6, 7, 8};
        sort(array);
        System.out.println(JSON.toJSONString(array));
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        // 定义双指针,选取left为比较值
        int l = left, r;
        for (r = left + 1; r <= right; r++) {
            if (array[r] < array[l]) {
                // 记录l值
                int swap = array[l];
                array[l] = array[r];
                array[r] = array[l + 1];
                array[l + 1] = swap;
                l++;
            }
        }
        sort(array, left, l);
        sort(array, l + 1, right);
    }
}
