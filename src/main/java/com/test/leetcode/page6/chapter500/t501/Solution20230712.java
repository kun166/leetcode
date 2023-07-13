package com.test.leetcode.page6.chapter500.t501;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230712
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/12 14:44
 * @Version: 1.0
 */
public class Solution20230712 {

    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
