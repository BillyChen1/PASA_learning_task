package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int n = s.length();
        int ans = 0;
        // 计数
        Map<Character, Integer> count = new HashMap<>();
        while (right < n) {
            // count[right]++
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            while (count.get(s.charAt(right)) > 1) {
                // 左边界右移
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            // 右边界右移
            right++;
        }
        return ans;
    }
}
