package com.test.leetcode.page2.chapter140.t144;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025032003
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 15:34
 * @Version: 1.0
 */
public class Solution2025032003 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(JSON.toJSONString(preorderTraversal(root)));
    }

    /**
     * 0ms	击败100.00%
     * 41.06MB	击败12.17%
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null) {

            if (root.left != null) {
                /**
                 * 如果存在左节点
                 */
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    // 第一次进来的时候,建立连接
                    /**
                     * 第一次进左节点,访问左节点
                     */
                    pre.right = root;
                    ans.add(root.val);
                    root = root.left;
                } else {
                    // 第二次进来了
                    /**
                     * 第二次进左节点,这其实是为了访问右节点
                     *
                     * 呃,呃……
                     * 下面这行
                     * root = pre.right;
                     * 代码根本是多余的……
                     */
                    root = pre.right;
                    pre.right = null;
                    root = root.right;
                }
            } else {
                /**
                 * 没有左节点,直接访问右节点
                 */
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
