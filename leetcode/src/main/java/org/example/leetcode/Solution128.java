package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        int curr = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                curr = 1;
                while (set.contains(num + 1)) {
                    curr++;
                    num++;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}
