package com.datastructures.trees;

import java.util.ArrayDeque;
import java.util.List;

public class MaxWidthBT {

    private int solve(TreeNode root) {

        ArrayDeque<List<Object>> queue = new ArrayDeque<>();
        queue.offer(List.of(root, 0));
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minindex = (int) queue.peek().get(1);
            int firstindex = -1;
            int lastindex = -1;
            for (int i = 0; i < size; i++) {

                List<Object> element = queue.poll();
                TreeNode node = (TreeNode) element.get(0);
                int index = (int) element.get(1);

                int currindex = index - minindex;

                if (i == 0) {
                    firstindex = currindex;
                }
                if (i == size - 1) {
                    lastindex = currindex;
                }

                if (null != node.left) {
                    queue.offer(List.of(node.left, currindex * 2 + 1));
                }

                if (null != node.right) {
                    queue.offer(List.of(node.right, currindex * 2 + 2));
                }
            }
            result = Math.max(result, lastindex - firstindex + 1);
        }
        return result;
    }
}
