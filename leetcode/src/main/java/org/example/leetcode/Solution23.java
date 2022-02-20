package org.example.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cqm
 * @date 2022/2/20
 **/
public class Solution23 {
    /**
     * 合并k个升序链表
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        // 小根堆
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            ListNode node = q.remove();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                q.add(node.next);
            }
        }
        return dummy.next;
    }
}
