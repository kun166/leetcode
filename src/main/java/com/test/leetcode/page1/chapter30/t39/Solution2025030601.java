package com.test.leetcode.page1.chapter30.t39;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 17:37
 * @Version: 1.0
 */
public class Solution2025030601 {

    @Test
    public void testBacktrackFirst() {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackFirst(new int[]{1, 2, 3, 4}, ans, new ArrayList<>(), 0);
        System.out.println(JSON.toJSONString(ans));
    }

    @Test
    public void testBacktrackSecond() {
        List<List<Integer>> ans = new ArrayList<>();
        backtrackSecond(new int[]{1, 2, 3, 4}, ans, new ArrayList<>(), 0);
        System.out.println(JSON.toJSONString(ans));
    }

    /**
     * 本类不是为了解这道题，而是研究递归-回溯的两种解法
     * 对对,继续探寻递归-回溯
     * <p>
     * [[],[1],[1,2],[1,2,3],[1,2,3,4],[1,2,3],[1,2],[1,2,4],[1,2],[1],[1,3],[1,3,4],[1,3],[1],[1,4],[1],[],
     * [2],[2,3],[2,3,4],[2,3],[2],[2,4],[2],[],
     * [3],[3,4],[3],[],
     * [4],[]]
     *
     * @param nums
     * @param ans
     * @param list
     * @param index
     */
    public void backtrackFirst(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        if (index == nums.length) {
            return;
        }
        // 1,选择。
        list.add(nums[index]);
        backtrackFirst(nums, ans, list, index + 1);
        list.remove(list.size() - 1);
        // 2,不选。
        backtrackFirst(nums, ans, list, index + 1);
    }


    /**
     * [[],[1],[1,2],[1,2,3],[1,2,3,4],[1,2,3],[1,2],[1,2,4],[1,2],[1],[1,3],[1,3,4],[1,3],[1],[1,4],[1],
     * [2],[2,3],[2,3,4],[2,3],[2],[2,4],[2],
     * [3],[3,4],[3],
     * [4]]
     * <p>
     * 这种实现方式,本质还是选择。
     * 对index及index以后的坐标进行选择。对，其实它的本质还是选择
     * 在生成的每一个list中的第一个字符，肯定都在初始的那次递归里
     * <p>
     * 这就保证这种方式,第一位肯定不同。第一位不同，list里存的就都不同了
     *
     * @param nums
     * @param ans
     * @param list
     * @param index
     */
    public void backtrackSecond(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            /**
             * 在初次递归方法里,就已经决定了将来生成的每一个list的第一个数，都是从这里选择的
             * 更确切的说吧，如果这个循环里面没选择数，那它就不会有后续的递归了
             */
            list.add(nums[i]);
            backtrackFirst(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
