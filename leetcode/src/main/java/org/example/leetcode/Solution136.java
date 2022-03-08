package org.example.leetcode;

import java.util.Arrays;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution136 {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
