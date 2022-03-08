package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 先不管random，当成普通链表来拷贝
        // map用来记录：原结点->拷贝的新节点
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        // 新链表的头节点
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            curr.next = node;
            curr = curr.next;
            map.put(tmp, node);
            tmp = tmp.next;
        }

        // 再遍历一次，处理随机指针
        tmp = head;
        curr = dummy.next;
        while (tmp != null) {
            if (tmp.random != null) {
                Node node = map.get(tmp.random);
                curr.random = node;
            }
            tmp = tmp.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
