package com.test.leetcode.page5.chapter480.t486;

/**
 * @ClassName: SolutionSecond20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 16:06
 * @Version: 1.0
 */
public class SolutionSecond20230703 {

    /**
     * 这题感觉贪心算法绝对可以
     * 呃，这个题是假贪心题，唉唉唉
     * [3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1]
     * 返回true
     * 其实false
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length, left = 0, right = n - 1, pick = 0, score1 = 0, score2 = 0;
        while (left <= right) {
            int index = bestPick(nums, left, right);
            if (pick % 2 == 0) {
                score1 += nums[index];
            } else {
                score2 += nums[index];
            }
            if (index == left) {
                left++;
            } else {
                right--;
            }
            pick++;
        }
        return score1 >= score2;
    }

    /**
     * 挑选最优的那个数
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int bestPick(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        if (right - left == 1) {
            return nums[left] >= nums[right] ? left : right;
        }

        // 选择最优的那个数
        // 这个地方如果左右两侧平衡的话，怎么选的？会不会影响之后的选择？
        return nums[left] - Math.max(nums[left + 1], nums[right]) >= nums[right] - Math.max(nums[left], nums[right - 1]) ?
                left : right;
    }
}
