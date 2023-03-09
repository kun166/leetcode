package com.test.leetcode.page3.chapter230.t234;

import com.test.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 10:34
 * @Version: 1.0
 */
public class OfficialFirst20230309 {

    /**
     * 方法一：将值复制到数组中后用双指针法
     * 呃，真是想不到，这个用list的居然比StringBuilder快4秒
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}
