package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/18
 **/
public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
       return rootSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);

    }

    /**
     * 以root为起点且路径总和为targetSum的路径数
     * @param root
     * @param targetSum
     * @return
     */
    public int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == targetSum) {
            count++;
        }
        count += rootSum(root.left, targetSum - root.val) + rootSum(root.right, targetSum - root.val);
        return count;
    }
}
