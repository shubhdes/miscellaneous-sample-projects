package com.datastructures.trees;

public class RootToNodeSum {

    private void solve(TreeNode node, int path, int[] sum) {

        if (null == node) {
            return;
        }

        path = (path * 10) + node.val;
        if (isLeaf(node)) {
            sum[0] = sum[0] + path;
            return;
        }
        solve(node.left, path, sum);
        solve(node.right, path, sum);
    }

    private boolean isLeaf(TreeNode node) {
        return null == node.left && null == node.right;
    }
}
