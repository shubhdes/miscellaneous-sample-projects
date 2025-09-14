package com.datastructures.trees;

public class LowestCommonAncestorBT {

    private TreeNode solve(TreeNode node, TreeNode p, TreeNode q) {

        if (null == node) {
            return null;
        }

        if (node == p || node == q) {
            return node;
        }

        TreeNode left = solve(node.left, p, q);
        TreeNode right = solve(node.right, p, q);

        if (null != left && null != right) {
            return node;
        }

        if (null != left) {
            return left;
        }

        return right;
    }
}
