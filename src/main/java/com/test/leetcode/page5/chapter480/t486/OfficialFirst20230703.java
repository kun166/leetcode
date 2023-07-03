package com.test.leetcode.page5.chapter480.t486;

/**
 * @ClassName: OfficeFirst20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 16:35
 * @Version: 1.0
 */
public class OfficialFirst20230703 {

    /**
     * 递归
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    /**
     * 获取的分数
     *
     * @param nums  可选的分数数组
     * @param start 数组左侧
     * @param end   数组右侧
     * @param turn  轮次，第一人选是1，第二个人是-1
     * @return
     */
    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            // start == end,说明仅仅剩下一个数了
            return nums[start] * turn;
        }
        // 选择左侧的数
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        // 选择右侧的数
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        // 这个返回难以理解啊
        /**
         * if(turn == 1){
         *             return Math.max(scoreStart ,scoreEnd );
         *         }else{
         *             return Math.min(scoreStart ,scoreEnd );
         *         }
         */
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }
}
