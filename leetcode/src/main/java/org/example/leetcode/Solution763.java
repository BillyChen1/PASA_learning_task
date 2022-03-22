package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cqm
 * @date 2022/3/22
 **/
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 统计字符的最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, map.get(s.charAt(i)));
            if (i == right) {
                ans.add(right - left + 1);
                left = i + 1;
            }
        }
        return ans;
    }
}
