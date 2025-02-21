package com.test.leetcode.page6.chapter530.t532;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OfficialFirst20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 17:31
 * @Version: 1.0
 */
public class OfficialFirst20230810 {

    public int findPairs(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }
}
