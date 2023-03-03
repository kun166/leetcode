package com.test.leetcode.page3.chapter220.t228;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official20230303
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/3 10:02
 * @Version: 1.0
 */
public class Official20230303 {


    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }

}
