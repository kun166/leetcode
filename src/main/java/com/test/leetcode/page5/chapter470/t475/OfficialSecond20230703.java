package com.test.leetcode.page5.chapter470.t475;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: OfficialSecond20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 09:09
 * @Version: 1.0
 */
public class OfficialSecond20230703 {

    @Test
    public void test() {
        System.out.println(findRadius(new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
