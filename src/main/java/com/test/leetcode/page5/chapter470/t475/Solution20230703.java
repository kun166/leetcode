package com.test.leetcode.page5.chapter470.t475;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 08:50
 * @Version: 1.0
 */
public class Solution20230703 {

    @Test
    public void test() {
        try (FileReader reader = new FileReader("/Users/qinfajia/code/leetcodetest");
             BufferedReader br = new BufferedReader(reader)) {
            String str1 = br.readLine();
            String str2 = br.readLine();
            String[] str1Array = str1.split(",");
            String[] str2Array = str2.split(",");
            int[] i1 = new int[str1Array.length];
            int[] i2 = new int[str2Array.length];
            for (int i = 0; i < str1Array.length; i++) {
                i1[i] = Integer.parseInt(str1Array[i]);
            }
            for (int i = 0; i < str2Array.length; i++) {
                i2[i] = Integer.parseInt(str2Array[i]);
            }
            System.out.println(findRadius(i1, i2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 双指针？
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int p1 = 0, p2 = 0;
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            // 呃，死在了>上……
            while (p2 < heaters.length - 1 && Math.abs(heaters[p2] - houses[i]) >= Math.abs(heaters[p2 + 1] - houses[i])) {
                p2 = p2 + 1;
            }
            ans = Math.max(ans, Math.abs(heaters[p2] - houses[i]));
        }
        return ans;
    }
}
