package com.datastructures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraversalBT {

    private List<List<Integer>> solve(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean lefttoright = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];
            int index;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.pop();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }

                index = (lefttoright) ? i : size - i - 1;
                level[index] = node.val;
            }
            result.add(Arrays.asList(level));
            lefttoright = !lefttoright;
        }
        return result;
    }
}
