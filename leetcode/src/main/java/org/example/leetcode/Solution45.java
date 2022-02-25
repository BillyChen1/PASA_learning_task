package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/2/25
 **/
public class Solution45 {
    /**
     * 跳跃游戏2
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0, step = 0, maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }
}
