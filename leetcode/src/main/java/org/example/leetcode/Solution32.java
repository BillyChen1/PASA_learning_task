package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cqm
 * @date 2022/3/23
 **/
public class Solution32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> st = new LinkedList<>();
        int ans = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                    if (st.isEmpty()) {
                        ans = Math.max(ans, i - start + 1);
                    } else {
                        ans = Math.max(ans, i - st.peek());
                    }
                } else {
                    start = i + 1;
                }
            }
        }
        return ans;
    }
}
