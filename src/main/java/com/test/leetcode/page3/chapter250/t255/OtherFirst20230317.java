package com.test.leetcode.page3.chapter250.t255;

import java.util.Arrays;

/**
 * @ClassName: OtherFirst20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 08:47
 * @Version: 1.0
 */
public class OtherFirst20230317 {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        int n = preorder.length;
        int i = 1;
        for (; i < n; ++i) {
            if (preorder[i] > preorder[0]) {
                break;
            }
        }
        for (int j = i; j < n; ++j) {
            if (preorder[j] < preorder[0]) {
                return false;
            }
        }
        return verifyPreorder(Arrays.copyOfRange(preorder, 1, i)) && verifyPreorder(Arrays.copyOfRange(preorder, i, n));
    }

}
