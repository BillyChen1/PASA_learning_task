package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/22
 **/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode n1 = pre.next;
            ListNode n2 = pre.next.next;
            pre.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            pre = n1;
        }
        return dummy.next;
    }
}
