package com.datastructures.trees;

public class MaxDiameterBT {

    private int maxdiameter(TreeNode node, int[] diameter) {

        if (null == node) {
            return 0;
        }

        int leftHt = maxdiameter(node.left, diameter);
        int rightHt = maxdiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHt + rightHt);

        return 1 + Math.max(leftHt, rightHt);
    }
}
