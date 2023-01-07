package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SolutionMorris20230104
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/4 09:20
 * @Version: 1.0
 */
public class SolutionMorris20230104 {

    /**
     * 感觉这方法，只适合中序遍历？
     * 一些前置知识：
     * 1,前驱节点，如果按照中序遍历访问树，访问的结果为ABC，则称A为B的前驱节点，B为C的前驱节点。
     * 2,前驱节点pre是curr左子树的最右子树（按照中序遍历走一遍就知道了）。
     * 3,由此可知，前驱节点的右子节点一定为空。
     * 主要思想：
     * 树的链接是单向的，从根节点出发，只有通往子节点的单向路程。
     * 中序遍历迭代法的难点就在于，需要先访问当前节点的左子树，才能访问当前节点。
     * 但是只有通往左子树的单向路程，而没有回程路，因此无法进行下去，除非用额外的数据结构记录下回程的路。
     * 在这里可以利用当前节点的前驱节点，建立回程的路，也不需要消耗额外的空间。
     * 根据前置知识的分析，当前节点的前驱节点的右子节点是为空的，因此可以用其保存回程的路。
     * 但是要注意，这是建立在破坏了树的结构的基础上的，因此我们最后还有一步“消除链接”’的步骤，将树的结构还原。
     * 重点过程： 当遍历到当前节点curr时，使用cuur的前驱节点pre
     * 1,标记当前节点是否访问过
     * 2,记录回溯到curr的路径（访问完pre以后，就应该访问curr了）
     * 以下为我们访问curr节点需要做的事儿：
     * 1,访问curr的节点时候，先找其前驱节点pre
     * 2,找到前驱节点pre以后，我们根据其右指针的值，来判断curr的访问状态：
     * 一,pre的右子节点为空，说明curr第一次访问，其左子树还没有访问，此时我们应该将其指向curr，并访问curr的左子树
     * 二,pre的右子节点指向curr，那么说明这是第二次访问curr了，也就是说其左子树已经访问完了，此时将curr.val加入结果集中
     * 更加细节的逻辑请参考代码：
     *
     * @param root
     * @return
     */
    public List<Integer> method3(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        while (root != null) {
            //没有左子树，直接访问该节点，再访问右子树
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            } else {
                //有左子树，找前驱节点，判断是第一次访问还是第二次访问
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root)
                    pre = pre.right;
                //是第一次访问，访问左子树
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }
                //第二次访问了，那么应当消除链接
                //该节点访问完了，接下来应该访问其右子树
                else {
                    pre.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
