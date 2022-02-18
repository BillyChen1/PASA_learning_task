package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cqm
 * @date 2022/2/18
 **/
public class Solution17 {

    private Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> ans = new ArrayList<>();

    /**
     * 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb);
        return ans;
    }

    public void dfs(String digits, int index, StringBuilder curr) {
        if (index == digits.length()) {
            ans.add(curr.toString());
            return;
        }

        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            curr.append(s.charAt(i));
            dfs(digits, index + 1, curr);
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

}
