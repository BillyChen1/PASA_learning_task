package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/13
 **/
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            //没有环的情况
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //让fast回到头节点
        //然后fast和slow同时向前移动
        //相遇点就是环的开始
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
