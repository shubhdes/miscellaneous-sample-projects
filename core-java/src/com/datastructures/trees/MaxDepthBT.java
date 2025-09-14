package com.datastructures.trees;

public class MaxDepthBT {

    private int solve(TreeNode node) {

        if (null == node) {
            return 0;
        }

        int leftHt = solve(node.left);
        int rightHt = solve(node.right);

        return 1 + Math.max(leftHt, rightHt);
    }
}
