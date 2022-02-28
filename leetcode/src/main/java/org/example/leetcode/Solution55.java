package org.example.leetcode;

public class Solution55 {
    /**
     * 跳跃游戏
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPosition) {
                return false;
            } else if (maxPosition >= nums.length - 1) {
                return true;
            }
            maxPosition = Math.max(maxPosition, nums[i] + i);
        }
        return true;
    }
}
