package com.test.leetcode.page4.chapter310.t314;

import com.test.leetcode.TreeNode;

import java.util.*;

/**
 * @ClassName: Solution20230417
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/17 09:34
 * @Version: 1.0
 */
public class Solution20230417 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了54.88%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了54.88%的用户
     * 通过测试用例：214 / 214
     *
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<TreeNodeIndex> deque = new LinkedList<>();
        deque.offer(new TreeNodeIndex(root, 0));
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNodeIndex treeNodeIndex = deque.pop();
                List<Integer> list = map.get(treeNodeIndex.index);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(treeNodeIndex.index, list);
                }
                list.add(treeNodeIndex.root.val);
                if (treeNodeIndex.root.left != null) {
                    deque.offer(new TreeNodeIndex(treeNodeIndex.root.left, treeNodeIndex.index - 1));
                }
                if (treeNodeIndex.root.right != null) {
                    deque.offer(new TreeNodeIndex(treeNodeIndex.root.right, treeNodeIndex.index + 1));
                }
                size--;
            }
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for (Integer i : keyList) {
            ans.add(map.get(i));
        }
        return ans;
    }


    class TreeNodeIndex {
        TreeNode root;
        int index;

        TreeNodeIndex(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }
}
