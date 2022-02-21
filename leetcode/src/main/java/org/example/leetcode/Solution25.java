package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/2/21
 **/
public class Solution25 {
    /**
     * k个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, end = dummy, start = pre.next;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            // prepare for next loop
            pre = start;
            end = pre;
            start = next;
        }
        return dummy.next;

    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
