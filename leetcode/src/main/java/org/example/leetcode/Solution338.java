package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i >> 1];
            }
        }
        return ans;
    }
}
