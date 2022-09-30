package com.test.leetcode.page1.chapter10.t18;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220929
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/29 19:28
 * @Version: 1.0
 */
public class Solution20220929 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296)));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ant = new ArrayList<>();
        if (nums.length < 4) {
            return ant;
        }
        // 先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long diff = (long) target - (long) nums[i] - (long) nums[j];
                int head = j + 1, tail = nums.length - 1;
                while (head < tail) {
                    if (diff == (long) nums[head] + (long) nums[tail]) {
                        ant.add(Arrays.asList(nums[i], nums[j], nums[head], nums[tail]));
                        head++;
                    } else if (diff > (long) nums[head] + (long) nums[tail]) {
                        head++;
                    } else {
                        tail--;
                    }
                    while (head > j + 1 && head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    while (tail < nums.length - 1 && head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                }
            }
        }
        return ant;
    }
}
