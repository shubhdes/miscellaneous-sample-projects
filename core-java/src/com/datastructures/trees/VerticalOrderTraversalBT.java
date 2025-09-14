package com.datastructures.trees;

import java.util.*;

public class VerticalOrderTraversalBT {

    private List<List<Integer>> solve(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> resultmap = new TreeMap<>();

        ArrayDeque<List<Object>> queue = new ArrayDeque<>();
        queue.offer(List.of(root, 0, 0));

        while (!queue.isEmpty()) {

            List<Object> nodeinfo = queue.poll();

            TreeNode node = (TreeNode) nodeinfo.get(0);
            int vertical = (int) nodeinfo.get(1);
            int level = (int) nodeinfo.get(2);

            if (!resultmap.containsKey(vertical)) {
                resultmap.put(vertical, new TreeMap<>());
            }

            if (!resultmap.get(vertical).containsKey(level)) {
                resultmap.get(vertical).put(level, new TreeSet<>());
            }

            resultmap.get(vertical).get(level).add(node.val);

            if (null != node.left) {
                queue.offer(List.of(node.left, vertical - 1, level + 1));
            }
            if (null != node.right) {
                queue.offer(List.of(node.right, vertical + 1, level + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeMap<Integer, TreeSet<Integer>>> entry : resultmap.entrySet()) {
            List<Integer> sublist = new ArrayList<>();
            for (Map.Entry<Integer, TreeSet<Integer>> subentry : entry.getValue().entrySet()) {
                sublist.addAll(subentry.getValue());
            }
            result.add(sublist);
        }

        return result;
    }
}
