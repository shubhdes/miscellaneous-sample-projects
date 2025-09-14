package com.datastructures.trees;

public class SymmetricBT {

    private boolean solve(TreeNode node1, TreeNode node2) {

        if (null == node1 && null == node2) {
            return true;
        }

        if (null == node2 || null == node1) {
            return false;
        }

        return (node1.val == node2.val)
                && solve(node1.left, node2.right)
                && solve(node1.right, node2.left);
    }
}
