package com.test.leetcode.page2.chapter140.t143;

import com.test.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 17:34
 * @Version: 1.0
 */
public class OfficialFirst20230202 {


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}
