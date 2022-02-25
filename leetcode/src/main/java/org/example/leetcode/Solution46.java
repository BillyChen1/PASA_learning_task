package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqm
 * @date 2022/2/25
 **/
public class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    boolean[] used;
    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums, 0);
        return ans;

    }

    public void dfs(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                curr.add(nums[i]);
                dfs(nums, index + 1);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}
