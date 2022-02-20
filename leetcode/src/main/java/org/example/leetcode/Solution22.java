package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqm
 * @date 2022/2/20
 **/
public class Solution22 {
    /**
     * 括号生成
     * @param n
     * @return
     */
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb);
        return ans;
    }

    /**
     *
     * @param left  剩余的左括号个数
     * @param right 剩余的右括号个数
     * @param sb
     */
    public void dfs(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }

        // 剩余的左括号比右括号多，直接返回
        if (left > right) {
            return;
        }

        if (left > 0) {
            sb.append("(");
            dfs(left - 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right > left) {
            sb.append(")");
            dfs(left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.printf(new Solution22().generateParenthesis(3).toString());
    }
}
