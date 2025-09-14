package com.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private void solve(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        leftboundary(root, result);
        leafnodes(root, result);
        rightboundary(root, result);
    }

    private void leftboundary(TreeNode root, List<Integer> result) {

        TreeNode node = root.left;

        while (null != node) {

            result.add(node.val);

            if (null != node.left) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
    }

    private void rightboundary(TreeNode root, List<Integer> result) {

        TreeNode node = root.right;

        while (null != node) {

            result.add(node.val);

            if (null != node.right) {
                node = node.right;
            }
            else {
                node = node.left;
            }
        }
    }

    private void leafnodes(TreeNode node, List<Integer> result) {

        if (isLeafNode(node)) {
            result.add(node.val);
            return;
        }

        if (null != node.left) {
            leafnodes(node.left, result);
        }

        if (null != node.right) {
            leafnodes(node.right, result);
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return null == node.left && null == node.right;
    }
}
