package com.datastructures.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TopViewBT {

    private List<Integer> solve(TreeNode root) {

        TreeMap<Integer, Integer> resultmap = new TreeMap<>();

        ArrayDeque<List<Object>> queue = new ArrayDeque<>();
        queue.offer(List.of(root, 0));

        while (!queue.isEmpty()) {

            List<Object> nodeinfo = queue.poll();

            TreeNode node = (TreeNode) nodeinfo.get(0);
            int vertical = (int) nodeinfo.get(1);

            if (!resultmap.containsKey(vertical)) {
                resultmap.put(vertical, node.val);
            }

            if (null != node.left) {
                queue.offer(List.of(node.left, vertical - 1));
            }
            if (null != node.right) {
                queue.offer(List.of(node.right, vertical + 1));
            }
        }

        List<Integer> result = new ArrayList<>(resultmap.values());
        return result;
    }
}
