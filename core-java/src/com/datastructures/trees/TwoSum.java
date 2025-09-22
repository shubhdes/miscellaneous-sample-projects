package com.datastructures.trees;

import java.util.Stack;

public class TwoSum {

    private boolean solve(TreeNode root, int target) {

        BSTIterator iterator1 = new BSTIterator(root, false);
        BSTIterator iterator2 = new BSTIterator(root, true);

        TreeNode left = iterator1.next();
        TreeNode right = iterator2.next();

        while (left.val < right.val) {
            if (left.val + right.val == target) {
                return true;
            }
            else if (left.val + right.val < target) {
                left = iterator1.next();
            }
            else {
                right = iterator2.next();
            }
        }
        return false;
    }

    class BSTIterator {

        private Stack<TreeNode> stack;
        private boolean reverse;

        public BSTIterator(TreeNode root, boolean reverse) {
            stack = new Stack<>();
            this.reverse = reverse;
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            while (null != node) {
                stack.push(node);
                if (!reverse) {
                    node = node.left;
                }
                else {
                    node = node.right;
                }
            }
        }

        public TreeNode next() {
            TreeNode node = stack.pop();
            if (!reverse) {
                pushAll(node.right);
            }
            else {
                pushAll(node.left);
            }
            return node;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}


