package com.datastructures.trees;

public class FlattenBTToLL {

    private void solve(TreeNode node, TreeNode[] prev) {

        if (null == node) {
            return;
        }

        solve(node.right, prev);
        solve(node.left, prev);

        node.right = prev[0];
        node.left = null;

        prev[0] = node;
    }
}
