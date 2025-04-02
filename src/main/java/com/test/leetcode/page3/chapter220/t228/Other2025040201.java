package com.test.leetcode.page3.chapter220.t228;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Other2025040201
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/2 09:12
 * @Version: 1.0
 */
public class Other2025040201 {

    /**
     * 0ms	击败100.00%
     * 40.80MB	击败72.65%
     * <p>
     * 呃,这0毫秒的代码没看出来有什么差距啊?
     * 就是用了StringBuilder?
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int first = 0, last = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) < nums.length && nums[i + 1] == nums[i] + 1) {
                last = i + 1;
            } else {
                if (first != last) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[first]).append("->").append(nums[last]);

                    list.add(sb.toString());
                    first = i + 1;
                    last = i + 1;
                } else {
                    String num1 = Integer.toString(nums[first]);
                    list.add(num1);
                    first = i + 1;
                    last = i + 1;
                }
            }
        }
        return list;

    }
}
