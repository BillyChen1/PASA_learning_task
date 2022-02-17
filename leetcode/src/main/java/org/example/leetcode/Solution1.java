package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    /**
     * leetcode1 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (numIndexMap.containsKey(compliment) && i != numIndexMap.get(compliment)) {
                return new int[]{i, numIndexMap.get(compliment)};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(new Solution1().twoSum(nums, target)));
    }
}
