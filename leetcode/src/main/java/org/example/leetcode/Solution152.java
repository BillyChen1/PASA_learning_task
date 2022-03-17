package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/13
 **/
public class Solution152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] imin = new int[nums.length]; // 以nums[i]结尾的最小乘积
        int[] imax = new int[nums.length]; // 以nums[i]结尾的最大乘积
        imax[0] = nums[0];
        imin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                imax[i] = Math.max(nums[i], nums[i] * imax[i - 1]);
                imin[i] = Math.min(nums[i], nums[i] * imin[i - 1]);
            } else {
                imax[i] = Math.max(nums[i], nums[i] * imin[i - 1]);
                imin[i] = Math.min(nums[i], nums[i] * imax[i - 1]);
            }
            max = Math.max(imax[i], max);
        }
        return max;
    }
}
