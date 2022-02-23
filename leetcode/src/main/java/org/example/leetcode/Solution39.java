package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cqm
 * @date 2022/2/23
 **/
public class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 组合总和
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<>();
        dfs(candidates, 0, curr, target);
        return ans;
    }

    public void dfs(int[] candidates, int begin, List<Integer> curr, int target) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            curr.add(candidates[i]);
            dfs(candidates, i, curr, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
