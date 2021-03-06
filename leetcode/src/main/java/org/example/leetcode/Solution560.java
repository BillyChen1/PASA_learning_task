package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cqm
 * @date 2022/3/21
 **/
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (map.containsKey(curr - k)) {
                ans += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}
