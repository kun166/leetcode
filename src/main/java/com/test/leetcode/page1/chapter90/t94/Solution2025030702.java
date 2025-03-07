package com.test.leetcode.page1.chapter90.t94;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025030702
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 16:12
 * @Version: 1.0
 */
public class Solution2025030702 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(JSON.toJSONString(inorderTraversal(root)));
    }

    /**
     * 来个有挑战性的迭代
     * <p>
     * 呃，居然做出来了……
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList();

        while (root != null || !ll.isEmpty()) {
            // 遍历左子树
            while (root != null) {
                /**
                 * 呃，把下面两行代码给互换了，导致空指针异常了
                 */
                ll.push(root);
                root = root.left;
            }
            root = ll.pop();
            list.add(root.val);
            // 遍历右子树
            root = root.right;
        }
        return list;
    }
}
