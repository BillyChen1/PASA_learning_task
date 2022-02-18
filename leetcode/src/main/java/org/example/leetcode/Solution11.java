package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/2/18
 **/
public class Solution11 {
    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int v = (j - i) * Math.min(height[i],height[j]);
            res = Math.max(v, res);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
