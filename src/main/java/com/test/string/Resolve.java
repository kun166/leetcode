package com.test.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 16:05
 */
public class Resolve {

    @Test
    public void test() {
//        int n = 4;
//        for (int i = 1; i <= n * n; i++) {
//            resolve(n, i);
//            System.out.println("----" + i);
//        }
        int n = 4;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            list.add(i);
        }
        int[] array = resolve(n, 1);
        for (int i : array) {
            System.out.print(i + ",");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            sb.append(list.remove(array[i]));
        }
        System.out.println(sb.toString());
    }

    public int[] resolve(int n, int k) {
        // k怎么分解
        int[] a = new int[n];
        int num = 1, index = 1;
        while (num < k) {
            index++;
            num *= index;
        }
        while (k > 0) {
            if (k >= num) {
                a[index] = k / num;
                k -= num * a[index];
            }
            while (num > k && k != 0) {
                num /= index;
                index--;
            }
        }
        return a;
    }
}
