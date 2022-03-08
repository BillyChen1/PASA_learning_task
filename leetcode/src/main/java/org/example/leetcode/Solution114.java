package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution114 {
    private List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        preOrder(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            TreeNode pre = list.get(i - 1);
            pre.left = null;
            pre.right = curr;
        }
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            list.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
