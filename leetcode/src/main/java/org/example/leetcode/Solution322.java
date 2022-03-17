package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示凑成i元所需的最少硬币数量
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
                if (dp[i] == 1) {
                    break;
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
