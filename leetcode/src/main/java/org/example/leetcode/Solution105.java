package org.example.leetcode;

/**
 * @author cqm
 * @date 2022/3/8
 **/
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preLeft, int preRight,
                                    int inLeft, int inRight) {
        if (preLeft > preRight)    return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        // 在中序遍历序列中寻找根的位置
        int k = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                k = i;  // 找到位置
                break;
            }
        }
        int len = k - inLeft;

        root.left = buildTreeHelper(preorder, inorder, preLeft + 1, preLeft+len, inLeft, k-1);
        root.right = buildTreeHelper(preorder, inorder, preLeft+len+1 , preRight, k+1, inRight);
        return root;
    }
}
