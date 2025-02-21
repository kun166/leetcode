package com.test.leetcode.page5.chapter440.t442;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230609
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/12 07:51
 * @Version: 1.0
 */
public class OfficialSecond20230609 {

    /**
     * 方法二：使用正负号作为标记
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            // 取当前位置上的数的绝对值
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                // 如果该绝对值上的下标表示的数大于0，则取相反数。
                nums[x - 1] = -nums[x - 1];
            } else {
                // 否则加入返回值(说明其它相等的数已经修改过了,重复了)
                ans.add(x);
            }
        }
        return ans;
    }
}
