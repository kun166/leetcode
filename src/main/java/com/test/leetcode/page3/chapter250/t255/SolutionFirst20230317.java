package com.test.leetcode.page3.chapter250.t255;

import java.util.Arrays;

/**
 * @ClassName: SolutionFirst20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 08:50
 * @Version: 1.0
 */
public class SolutionFirst20230317 {


    /**
     * 根据OtherFirst20230317改编的
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    public boolean verifyPreorder(int[] preorder, int left, int right) {
        // 只有一个节点了，或者是没有节点
        if (left >= right) {
            return true;
        }
        // 寻找右子树节点
        // left是根节点，所以从left+1开始找
        int i = left + 1;
        for (; i <= right; i++) {
            if (preorder[i] > preorder[left]) {
                break;
            }
        }
        // i点就是右子树开始的节点
        for (int j = i + 1; j <= right; j++) {
            // 右子树中有节点小于根节点
            if (preorder[j] < preorder[left]) {
                return false;
            }
        }
        return verifyPreorder(preorder, left + 1, i - 1) && verifyPreorder(preorder, i, right);
    }
}
