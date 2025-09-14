package com.datastructures.trees;

public class ValidateBST {

    private boolean solve(TreeNode node, int min, int max) {

        if (null == node) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return solve(node.left, min, node.val) && solve(node.right, node.val, max);
    }
}
