package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/17
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null) {
            return root;
        } else {
            return null == left ? right : left;
        }
    }
}
