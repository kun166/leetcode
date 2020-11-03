package com.test.leetcode.chapter10.t15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-14 16:13
 */
public class OfficialSution {

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, 3, -1, -4, -5};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> a : list) {
            System.out.println();
            for (int i : a) {
                System.out.print(i + " ");
            }
        }

    }

    /**
     * 牛逼的解法，心服口服
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 先排序。像这种不重复的组合，必须排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同。
            // first > 0 保证 first-1 不会越界访问
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            // 要寻找的那个数
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                // 这个和第一层循环时候一样，需要去重
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                // 如果second 加上最右侧的数，还是小于target，则下面的while就不走了
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
