package org.example.leetcode;

import java.util.PriorityQueue;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                q.add(nums[i]);
            } else {
                if (nums[i] > q.peek()) {
                    q.remove();
                    q.add(nums[i]);
                }
            }
        }
        return q.peek();
    }
}
