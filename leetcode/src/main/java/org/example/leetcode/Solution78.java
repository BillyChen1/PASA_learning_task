package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    /**
     * 子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // choose
        curr.add(nums[i]);
        dfs(nums, i + 1);
        curr.remove(curr.size() - 1);

        // don't choose
        dfs(nums, i + 1);
    }
}
