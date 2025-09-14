package com.datastructures.trees;

public class KthSmallestElementBST {

    private int solve(TreeNode node, int[] count, int k) {

        if (node == null) {
            return -1;
        }

        int left = solve(node.left, count, k);
        if (left != -1) {
            return left;
        }

        count[0]++;
        if (count[0] == k) {
            return node.val;
        }

        int right = solve(node.right, count, k);
        if (right != -1) {
            return right;
        }

        return -1;
    }
}
