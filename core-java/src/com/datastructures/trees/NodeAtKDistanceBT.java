package com.datastructures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NodeAtKDistanceBT {

    private ArrayList<Integer> solve(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> parentmap = new HashMap<>();
        getparentmap(root, parentmap);

        HashSet<TreeNode> visited = new HashSet<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        visited.add(target);

        int distance = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            if (distance == k) {
                break;
            }
            distance++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (null != node.left && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                if (null != node.right && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = parentmap.get(node);
                if (null != parent && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    private void getparentmap(TreeNode root, HashMap<TreeNode, TreeNode> parentmap) {

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (null != node.left) {
                queue.offer(node.left);
                parentmap.put(node.left, node);
            }

            if (null != node.right) {
                queue.offer(node.right);
                parentmap.put(node.right, node);
            }
        }
    }
}
