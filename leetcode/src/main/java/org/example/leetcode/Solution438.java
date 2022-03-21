package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cqm
 * @date 2022/3/18
 **/
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (sLen < pLen) {
            return ans;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
