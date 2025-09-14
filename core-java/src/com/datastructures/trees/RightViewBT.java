package com.datastructures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightViewBT {

    private List<Integer> solve(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            result.add(queue.peekLast().val);
            int size = queue.size();

            while (size > 0) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return result;
    }
}
