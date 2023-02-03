package com.test.leetcode.page2.chapter140.t145;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SolutionSecond20230203
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/3 08:31
 * @Version: 1.0
 */
public class SolutionSecond20230203 {

    /**
     * 迭代吧
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 这个deque一定要仔细理解，存放的数据和前序遍历，中序遍历不太一样
        Deque<TreeNode> deque = new LinkedList<>();
        // 记录处理的上一个节点，用于判断是不是当前节点的右节点
        // 准确点说，只需要记录右子树，左子树不需要关注。只是为了判断右子树是不是访问过
        TreeNode pre = null;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                // 傻逼了，第一次把这两行代码位置给交换了……
                deque.push(root);
                root = root.left;
            }
            // 走到这一步的时候，说明左子树已经访问结束了，下面代码，是为了处理右子树的(可能还有根节点)
            // 这个地方一定要理解，deque.pop()出来的一定是刚处理过的节点的父节点。
            // 当然这个一定是父节点，也是自己代码保证的，怎么保证的？
            // 访问右子树的时候，继续把当前父节点压入栈中保证的……
            root = deque.pop();
            // pre要和root.right比较，这个地方第一次搞错了，和root比较，死循环了
            if (root.right != null && pre != root.right) {
                // 如果有右子树，且右子树没有访问过，则访问右子树
                // 继续把root放入到栈中，
                // 目的是为了处理完root.right之后,deque.pop()出来的是root.right的父节点root
                deque.push(root);
                // 下面这行代码可以没有
                pre = root;
                root = root.right;
            } else {
                // 右子树为空，或者右子树处理过了
                list.add(root.val);
                pre = root;
                // 设置为空，是为了循环立马执行deque.pop(),处理栈的下一个节点
                root = null;
            }
        }
        return list;
    }
}
