package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/2/17
 **/
public class Solution5 {
    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // 中心扩散法
        int longestLenth = 0;
        int begin = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = longestLength(s, i, i);
            int len2 = longestLength(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > longestLenth) {
                longestLenth = len;
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public int longestLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
