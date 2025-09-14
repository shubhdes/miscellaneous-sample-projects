package com.datastructures.trees;

public class DeleteNodeBST {

    private TreeNode solve(TreeNode root, int target) {

        TreeNode node = root;
        while (null != node) {

            if (node.val > target) {
                if (node.left != null && node.left.val == target) {
                    node.left = deleteNode(node.left);
                }
                else {
                    node = node.left;
                }
            }
            else {
                if (node.right != null && node.right.val == target) {
                    node.right = deleteNode(node.right);
                }
                else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode node) {

        if (null == node.left) {
            return node.right;
        }

        if (null == node.right) {
            return node.left;
        }

        TreeNode leftsubtree = node.left;
        TreeNode rightsubtree = node.right;

        TreeNode extremerightnodeoflst = extremeright(leftsubtree);
        extremerightnodeoflst.right = rightsubtree;

        return node.left;
    }

    private TreeNode extremeright(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return extremeright(node.right);
    }
}
