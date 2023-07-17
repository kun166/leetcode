package com.test.leetcode.page6.chapter500.t506;

/**
 * @ClassName: Other20230717
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/17 07:47
 * @Version: 1.0
 */
public class Other20230717 {

    /**
     * 想法牛逼的不行不行的。
     * 缺点应该就是比较占内存
     *
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] result = new String[n];
        int max = 0;
        // 找出找出最高的成绩
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        // 下标为成绩，值为成绩在 nums 数组的下标
        // 建立max+1，而不是max的长度数组是因为，如果建立max的话，第一名是0
        // 但是array会有很多很多无效的0，所以需要建立max+1长度的数组
        int[] array = new int[max + 1];
        for (int i = 0; i < n; i++) {
            array[nums[i]] = i + 1;
        }
        // 记录当前成绩的排名
        int count = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                // 根据排名进行赋值
                switch (count) {
                    case 1:
                        result[array[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        result[array[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        result[array[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        result[array[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }
        return result;
    }
}
