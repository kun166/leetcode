package com.test.leetcode.page2.chapter150.t156;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OtherThird20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 10:37
 * @Version: 1.0
 */
public class OtherThird20230313 {

    // 迭代版本 从右上往左下遍历
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        // x记录的是当前节点y的父节点重新生成的树
        // y记录的是当前需要处理的节点
        // z记录的是当前节点y的父节点的右子树，也即将要成为当前节点y的左子树
        TreeNode x = null, y = root, z = null;
        while (y != null) {
            // 先记下y原来的左子节点防止丢失, 因为下面会修改y的左指针
            TreeNode left = y.left;
            // y的左指针指向z
            y.left = z;
            // 记下y的右指针，下次用
            z = y.right;
            // y的右指针指向x
            y.right = x;
            // y 成为新的x
            x = y;
            // y 往左下扎，一直扎到底为止
            y = left;
        }
        // 退出循环时 y == null 了，说明y已经扎到左边最底了，
        // 此时的 x 是 y 的父节点，也就是最终要返回的根节点
        return x;
    }

}
