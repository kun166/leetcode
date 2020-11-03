package com.test.leetcode.chapter10.t11;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 14:01
 */
public class OfficialSulution {

    @Test
    public void test() {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWater(array));
    }


    public int maxWater(int[] array) {
        int length = array.length;
        int lp = 0, rp = length - 1;
        int max = 0;
        while (lp < rp) {
            int area;
            if (array[lp] <= array[rp]) {
                area = array[lp] * (rp - lp);
                lp++;
            } else {
                area = array[rp] * (rp - lp);
                rp--;
            }
            if (area > max) max = area;
        }
        return max;
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
