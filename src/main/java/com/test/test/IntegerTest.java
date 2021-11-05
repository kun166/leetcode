package com.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-09 20:24
 */
public class IntegerTest {

    @Test
    public void test() {
        int number = 1000;
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append((char) (number % 2 + '0'));
            number /= 2;
        }
        System.out.println(sb.reverse().toString());
        System.out.println(Integer.toBinaryString(1000));
    }

    @Test
    public void test1() {
        int n = 1;
        for (int i = 0; i < 5; i++) {
            n <<= 1;
            System.out.println(n);
        }
    }

    @Test
    public void test2() {
        System.out.println(Integer.MAX_VALUE + 1);
    }

    @Test
    public void test3() {
        long h = Integer.MAX_VALUE * 19L;
        System.out.println(h);
        System.out.println(h >>> 2);
        System.out.println(Long.toBinaryString(h ^ (h >>> 16)));
    }

    @Test
    public void test4() {
        System.out.println(Integer.numberOfLeadingZeros(0));
        System.out.println(Integer.numberOfLeadingZeros(1));
    }

    @Test
    public void test5() {
        int COUNT_BITS = Integer.SIZE - 3;
        int a = (-1 << COUNT_BITS + 1) & ~((1 << COUNT_BITS) - 1);
        System.out.println(Integer.toBinaryString(~((1 << COUNT_BITS) - 1)));

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test6() {
        int[] array = new int[5];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            array[index++] = i;
        }
        System.out.println(JSON.toJSONString(array));
    }

    @Test
    public void test7() {
        System.out.println(Integer.toBinaryString(16384));
        int num = 1;
        for (int i = 0; i < 16; i++) {
            num *= 2;
        }
        System.out.println(num);
        System.out.println(65536 / 4);
    }

    @Test
    public void test8() {
        int i = 2903948;
        System.out.println(i * 10000000L + i);
    }

    @Test
    public void test9() {
        System.out.println(-5 >> 1);
        System.out.println(-5 >> 2);
        System.out.println(-5 >> 3);
        System.out.println(-5 >> 3);
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(-5));
    }

    @Test
    public void test10() {
        int number = 1;
        number *= 26 * 26 + 25;
        System.out.println(number);
    }


}
