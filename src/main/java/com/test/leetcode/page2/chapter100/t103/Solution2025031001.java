package com.test.leetcode.page2.chapter100.t103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 17:49
 * @Version: 1.0
 */
public class Solution2025031001 {


    /**
     * 官方解答，好像有更好的方式，先用自己的理解做吧
     * <p>
     * 1ms 击败76.02%
     * 41.56MB 击败19.19%
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.offer(root);
        boolean fromLeft = true;
        while (!ll.isEmpty()) {
            int size = ll.size();
            List<Integer> list = new ArrayList<>();
            while (--size >= 0) {
                TreeNode node = ll.pop();
                list.add(node.val);
                if (node.left != null)
                    ll.offer(node.left);
                if (node.right != null)
                    ll.offer(node.right);
            }
            ans.add(fromLeft ? list : reverse(list));
            fromLeft = !fromLeft;
        }
        return ans;
    }

    public List<Integer> reverse(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        int left = 0, right = array.length - 1;
        while (left < right) {
            Integer mid = array[left];
            array[left] = array[right];
            array[right] = mid;
            left++;
            right--;
        }
        return Arrays.asList(array);
    }
}
