package com.test.leetcode.page5.chapter490.t491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: OfficialFirst20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 15:29
 * @Version: 1.0
 */
public class OfficialFirst20230704 {

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Set<Integer> set = new HashSet<Integer>();
    int n;

    /**
     * 方法一：二进制枚举 + 哈希
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }

}
