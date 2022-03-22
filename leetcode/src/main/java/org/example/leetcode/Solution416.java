package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/18
 **/
public class Solution416 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = true;
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = true;
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
