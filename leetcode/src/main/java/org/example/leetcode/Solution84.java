package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    /**
     * 柱状图中最大的矩形
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        // 单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                ans = Math.max(ans, h * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return ans;
    }
}
