package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution85 {
    /**
     * 最大矩形
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
             return 0;
         }
         int ans = 0;
         int[] heights = new int[matrix[0].length];
         for (int i = 0; i < matrix.length; i++) {
             for (int j = 0; j < matrix[0].length; j++) {
                 heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
             }
             ans = Math.max(ans, largestRectangleArea(heights));
         }
         return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 1];
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
