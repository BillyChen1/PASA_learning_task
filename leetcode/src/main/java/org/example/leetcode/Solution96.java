package org.example.leetcode;

public class Solution96 {
    /**
     * 不同的二叉搜索树
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] C = new int[n + 1];
        C[0] = 1;
        C[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                C[i] += C[j] * C[i - j - 1];
            }
        }
        return C[n];
    }
}
