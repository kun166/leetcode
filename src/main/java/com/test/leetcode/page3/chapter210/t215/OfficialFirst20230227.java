package com.test.leetcode.page3.chapter210.t215;

import java.util.Random;

/**
 * @ClassName: OfficialFirst20230227
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/27 11:26
 * @Version: 1.0
 */
public class OfficialFirst20230227 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * 寻找排好序后，第index位置的元素值
     *
     * @param a     查找的数组
     * @param l     左侧开始下标
     * @param r     右侧开始下标
     * @param index 寻找的下标
     * @return
     */
    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
