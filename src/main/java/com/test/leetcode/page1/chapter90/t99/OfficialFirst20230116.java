package com.test.leetcode.page1.chapter90.t99;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 14:57
 * @Version: 1.0
 */
public class OfficialFirst20230116 {

    /**
     * 显式中序遍历
     * 我们来看下如果在一个递增的序列中交换两个值会造成什么影响。
     * 假设有一个递增序列 a=[1,2,3,4,5,6,7]。
     * 如果我们交换两个不相邻的数字，例如2和6，原序列变成了a=[1,6,3,4,5,2,7]，
     * 那么显然序列中有两个位置不满足a[i]<a[i+1]，
     * 在这个序列中体现为 6>3，5>2，因此只要我们找到这两个位置，即可找到被错误交换的两个节点。
     * 如果我们交换两个相邻的数字，例如2和3，此时交换后的序列只有一个位置不满足a[i]<a[i+1]。
     * 因此整个值序列中不满足条件的位置或者有两个，或者有一个。
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    /**
     * 这个方法，其实就是递归方式的中序遍历
     *
     * @param root 当前节点
     * @param nums 中序遍历后保存数据的数组
     */
    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    /**
     * 遍历数组，找出交换的那两个点的数值
     *
     * @param nums
     * @return
     */
    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    /**
     * 交换两个点的数值
     *
     * @param root
     * @param count
     * @param x
     * @param y
     */
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}
