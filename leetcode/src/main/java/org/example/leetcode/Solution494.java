package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/20
 **/
public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num);
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        // 前i个数凑成j的方法数
        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][0 + sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (j + sum - nums[i - 1] >= 0) {
                    dp[i][j + sum] += dp[i - 1][j + sum - nums[i - 1]];
                }
                if (j + sum + nums[i - 1] <= 2 * sum) {
                    dp[i][j + sum] += dp[i - 1][j + sum + nums[i - 1]];
                }
            }
        }
        return  dp[n][target + sum];
    }
}
