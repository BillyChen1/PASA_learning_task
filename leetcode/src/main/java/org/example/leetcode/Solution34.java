package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/2/21
 **/
public class Solution34 {
    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
