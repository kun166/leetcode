package com.test.leetcode.page3.chapter250.t259;

import java.util.Arrays;

/**
 * @ClassName: OfficialFrist20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 08:39
 * @Version: 1.0
 */
public class OfficialFirst20230318 {

    /**
     * 二分法
     * 执行用时：316 ms, 在所有 Java 提交中击败了6.18%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了80.34%的用户
     * 通过测试用例：316 / 316
     * <p>
     * 颠覆三观，这个算法居然比Solution20230318慢……
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    /**
     * 从起始位置，查询nums中两个数之和小于目标值的数目
     *
     * @param nums       查找的数组
     * @param startIndex 其实位置
     * @param target     目标值
     * @return
     */
    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        for (int i = startIndex; i < nums.length - 1; i++) {
            int j = binarySearch(nums, i, target - nums[i]);
            sum += j - i;
        }
        return sum;
    }

    /**
     * 从startIndex开始，采用二分法，查找小于target的值
     *
     * @param nums
     * @param startIndex
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int startIndex, int target) {
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            // 小技巧啊，能保证mid一定大于left，不至于陷入死循环
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}
