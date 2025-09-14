package com.datastructures.trees;

public class LowestCommonAncestorBST {

    private TreeNode solve(TreeNode node, TreeNode p, TreeNode q) {

        if (null == node) {
            return null;
        }

        if (node.val > p.val && node.val > q.val) {
            return solve(node.left, p, q);
        }

        if (node.val < p.val && node.val < q.val) {
            return solve(node.right, p, q);
        }

        return node;
    }
}
