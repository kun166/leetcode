package com.test.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: FastSortThird
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/13 16:14
 * @Version: 1.0
 */
public class FastSortThird {

    @Test
    public void test() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(JSON.toJSONString(array));
        sort(array);
        System.out.println(JSON.toJSONString(array));
    }

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // 定义前后指针,选择right为分界点
        int l = left, r = left;
        for (; r < right; r++) {
            if (array[r] < array[right]) {
                // 交换l,r
                swap(array, l, r);
                l++;
            }
        }
        swap(array, l, right);
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }

    public void swap(int[] array, int left, int right) {
        int mid = array[left];
        array[left] = array[right];
        array[right] = mid;
    }
}
