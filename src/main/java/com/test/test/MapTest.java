package com.test.test;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-26 16:11
 */
public class MapTest {


    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(1 << 10, 1.0f);
        int number = 1, step = 1 << 10;
        for (int i = 0; i < 9; i++) {
            map.put(number, number);
            number += step;
        }
    }
}
