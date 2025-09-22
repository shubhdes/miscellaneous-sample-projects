package com.datastructures.trees;


public class RecoverBST {

    private void solve(TreeNode root) {
        TreeNode[] prev = {null};
        TreeNode[] violations = {null, null, null};
        solve(root, prev, violations);

        if (null != violations[0] && null != violations[2]) {
            swap(violations[0], violations[2]);
        }
        else if (null != violations[0] && null != violations[1]) {
            swap(violations[0], violations[1]);
        }
    }

    private void solve(TreeNode node, TreeNode[] prev, TreeNode[] violations) {

        if (null == node) {
            return;
        }

        solve(node.left, prev, violations);

        if (null != prev[0] && node.val < prev[0].val) {

            if (null == violations[0]) {
                violations[0] = prev[0];
                violations[1] = node;
            }
            else {
                violations[2] = node;
            }
        }
        prev[0] = node;
        solve(node.right, prev, violations);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int t = node1.val;
        node1.val = node2.val;
        node2.val = t;
    }
}
