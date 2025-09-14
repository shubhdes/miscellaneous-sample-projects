package com.datastructures.trees;

import java.util.HashMap;

public class BTFromInPostOrder {

    private TreeNode solve(int[] inorder, int[] preorder, int n) {
        HashMap<Integer, Integer> indexmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexmap.put(inorder[i], i);
        }

        return solve(inorder,0, n - 1, preorder,0, n - 1, indexmap);
    }

    private TreeNode solve(int[] inorder, int istart, int iend,
                           int[] preorder, int pstart, int pend, HashMap<Integer, Integer> indexmap) {

        if (pstart > pend || istart > iend) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[pend]);

        int rootindex = indexmap.get(preorder[pend]);
        int leftcount = rootindex - istart;

        node.left = solve(inorder, istart, rootindex - 1,
                          preorder, pstart, pstart + leftcount - 1, indexmap);
        node.right = solve(inorder, rootindex + 1, iend,
                           preorder, pstart + leftcount, pend - 1, indexmap);
        return node;
    }
}
