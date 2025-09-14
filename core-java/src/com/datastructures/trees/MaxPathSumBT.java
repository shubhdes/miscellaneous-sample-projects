package com.datastructures.trees;

public class MaxPathSumBT {

    private int maxpathsum(TreeNode node, int[] sum) {

        if (null == node) {
            return 0;
        }

        int leftsum = Math.max(0, maxpathsum(node.left, sum));
        int rightsum = Math.max(0, maxpathsum(node.right, sum));

        sum[0] = Math.max(sum[0], node.val + leftsum + rightsum);

        return node.val + Math.max(leftsum, rightsum);
    }
}
