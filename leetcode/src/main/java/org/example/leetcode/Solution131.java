package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution131 {
    private List<List<String>> ans = new ArrayList<>();
    private List<String> curr = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return ans;
        }

        dfs(0, s, len);
        return ans;


    }

    // index表示以下标为index的位置为起点开始切分，str表示字符串，len为arr的长度
    public void dfs(int index, String str, int len) {
        if (index == len) {
            ans.add(new ArrayList<String>(curr));
            return;
        }

        for (int i = index; i < len; i++) {
            if (isPalindrome(str, index, i)) {
                curr.add(str.substring(index, i + 1));
                dfs(i + 1, str, len);
                //回溯
                curr.remove(curr.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String str, int begin, int end) {
        while (begin <= end) {
            if (str.charAt(begin) == str.charAt(end)) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
