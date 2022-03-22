package org.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cqm
 * @date 2022/3/22
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "None";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(list));
        return deserializeHelper(dataList);
    }

    public TreeNode deserializeHelper(List<String> dataList) {
        String rootVal = dataList.remove(0);
        if ("None".equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        return root;
    }
}
