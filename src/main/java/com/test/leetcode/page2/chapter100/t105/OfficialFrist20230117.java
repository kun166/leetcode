package com.test.leetcode.page2.chapter100.t105;

import com.test.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-05-19 14:52
 */
public class OfficialFrist20230117 {

    private Map<Integer, Integer> indexMap;

    /**
     * 递归方式
     * 对于任意一颗树而言，前序遍历的形式总是
     * [根节点,[左子树的前序遍历结果],[右子树的前序遍历结果]]
     * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
     * [[左子树的中序遍历结果], 根节点, [右子树的中序遍历结果]]
     * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。
     * 由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，
     * 对上述形式中的所有左右括号进行定位。
     * <p>
     * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，
     * 以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，
     * 再将这两颗子树接到根节点的左右位置。
     *
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 保存中序遍历的位置
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * @param preorder       前序遍历数组
     * @param inorder        中序遍历数组
     * @param preorder_left  前序数组开始下标
     * @param preorder_right 前序数组结束下标
     * @param inorder_left   中序数组开始下标
     * @param inorder_right  中序数组结束下标
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点。该节点前的分布分布在左子树，节点后的分布在右子树
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目。
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }


}
