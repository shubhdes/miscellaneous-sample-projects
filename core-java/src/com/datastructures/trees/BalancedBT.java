package com.datastructures.trees;

public class BalancedBT {

    public int solve(TreeNode node) {

        if (null == node) {
            return 0;
        }

        int leftHt = solve(node.left);
        int rightHt = solve(node.right);

        if (leftHt == -1 || rightHt == -1 || Math.abs(leftHt - rightHt) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHt, rightHt);
    }
}
