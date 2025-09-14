package com.datastructures.trees;

public class InsertNodeBST {

    private TreeNode solve(TreeNode root, int target) {

        TreeNode node = root;
        while (null != node) {

            if (node.val > target) {

                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(target);
                    break;
                }
            } else {

                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(target);
                    break;
                }
            }
        }

        return root;
    }
}
