package com.test.sort;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: FastSortSecond
 * @Description:
 * @Author: qinfajia
 * @Date: 2024/5/13 15:42
 * @Version: 1.0
 */
public class FastSortSecond {
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
        int l = left, r = right;
        while (l < r) {
            // 选择了left做分界线,必须先从右向左找。否则如果left是数组里面最小值，就会有问题了
            while (l < r && array[r] >= array[left])
                r--;
            while (l < r && array[l] <= array[left])
                l++;
            // 找到左端大于left,且右端小于left的,交换
            swap(array, l, r);
        }
        swap(array, left, r);

        sort(array, left, r);
        sort(array, r + 1, right);
    }

    public void swap(int[] array, int left, int right) {
        int mid = array[left];
        array[left] = array[right];
        array[right] = mid;
    }
}
