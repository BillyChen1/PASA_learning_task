package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cqm
 * @date 2022/2/19
 **/
public class Solution20 {
    /**
     * 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if ((c == ')' && stack.peek() == '(')
                        || (c == ']' && stack.peek() == '[')
                        || (c == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
