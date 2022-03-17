package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //如果原链表节点个数是奇数
        if (fast != null) {
            //让slow指向链表后半部分的第一个元素
            slow = slow.next;
        }

        fast = head;
        //翻转后半部分
        ListNode ret = reverse(slow);

        //开始判断前后两部分是否相同
        while (ret != null) {
            if (ret.val != fast.val) {
                return false;
            }
            ret = ret.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
