package org.example.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //单调递减栈
        //队首始终为最大元素
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        ans[0] = nums[q.peekFirst()];
        for (int i = k; i < len; i++) {
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
            //如果队列中最大值的索引在当前窗口之外，则将其弹出
            while (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            ans[i - k + 1] = nums[q.peekFirst()];
        }
        return ans;
    }
}
