package com.test.leetcode.page2.chapter160.t167;

/**
 * @ClassName: SolutionSecond20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 09:26
 * @Version: 1.0
 */
public class SolutionSecond20230209 {

    /**
     * 双指针吧
     * 下面官方的解释，通透易懂，佩服佩服
     * <p>
     * 使用双指针的实质是缩小查找范围。那么会不会把可能的解过滤掉？答案是不会。
     * 假设numbers[i]+numbers[j] = target是唯一解，其中0<=i<j<numbers.length - 1。
     * 初始时两个指针分别指向下标0和下标 numbers.length - 1，左指针指向的下标小于或等于i，
     * 右指针指向的下标大于或等于j。除非初始时左指针和右指针已经位于下标i 和 j，
     * 否则一定是左指针先到达下标 i 的位置或者右指针先到达下标 j 的位置。
     * <p>
     * 如果左指针先到达下标i 的位置，此时右指针还在下标j 的右侧，sum>target，因此一定是右指针左移，
     * 左指针不可能移到i 的右侧。
     * <p>
     * 如果右指针先到达下标j 的位置，此时左指针还在下标 i 的左侧，sum<target，因此一定是左指针右移，
     * 右指针不可能移到j 的左侧。
     * <p>
     * 由此可见，在整个移动过程中，左指针不可能移到 i 的右侧，右指针不可能移到 j 的左侧，
     * 因此不会把可能的解过滤掉。由于题目确保有唯一的答案，因此使用双指针一定可以找到答案。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
