package org.example.leetcode;

public class Solution101 {
    /**
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    public boolean cmp(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val && cmp(t1.left, t2.right) && cmp(t1.right, t2.left);
    }
}
