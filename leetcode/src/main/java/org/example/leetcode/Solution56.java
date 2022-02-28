package org.example.leetcode;

import java.util.Arrays;

public class Solution56 {
    /**
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (i == 0 || interval[0] > res[i - 1][1]) {
                // 新的区间
                res[i++] = interval;
            } else {
                res[i - 1][1] = Math.max(res[i - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, i);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new Solution56().merge(intervals)));
    }
}
