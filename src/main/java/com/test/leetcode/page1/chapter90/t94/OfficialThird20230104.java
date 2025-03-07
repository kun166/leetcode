package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialThird20230104
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/4 09:09
 * @Version: 1.0
 */
public class OfficialThird20230104 {

    /**
     * Morris 中序遍历。这是一种新的解题方法
     * 1,如果x无左孩子，先将x的值加入答案数组，再访问x的右孩子，即x=x.right。
     * 2,如果x有左孩子，则找到x左子树上最右的节点（即左子树中序遍历的最后一个节点，x在中序遍历中的前驱节点），
     * 我们记为predecessor。根据predecessor的右孩子是否为空，进行如下操作。
     * 一,如果predecessor的右孩子为空，则将其右孩子指向 x，然后访问 x 的左孩子，即x=x.left。
     * 二,如果predecessor的右孩子不为空，则此时其右孩子指向x，说明我们已经遍历完x的左子树，我们将predecessor的右孩子置空，将x的值加入答案数组，然后访问x的右孩子，即x=x.right。
     * 3,重复上述操作，直至访问完整棵树。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }


                if (predecessor.right == null) {
                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 说明左子树已经访问完了，我们需要断开链接
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                // 如果没有左孩子，则直接访问右孩子
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
