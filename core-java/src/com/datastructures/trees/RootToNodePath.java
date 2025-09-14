package com.datastructures.trees;

import java.util.ArrayList;

public class RootToNodePath {

    private boolean solve(TreeNode node, ArrayList<Integer> path, int target) {

        if (null == node) {
            return false;
        }

        path.add(node.val);
        if (target == node.val) {
            return true;
        }

        boolean result = solve(node.left, path, target) || solve(node.right, path, target);

        if (!result) {
            path.remove(path.size() - 1);
        }

        return result;
    }
}
