package com.datastructures.trees;

public class BSTFromPreOrder {

    private TreeNode solve(int[] preorder, int[] index, int max) {

        if (index[0] == preorder.length || preorder[index[0]] > max) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index[0]]);
        preorder[index[0]]++;

        node.left = solve(preorder, index, node.val);
        node.right = solve(preorder, index, max);

        return node;
    }
}
