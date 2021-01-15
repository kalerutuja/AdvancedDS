package com.bhole.advanced_ds.random.medium.tree;

import com.bhole.advanced_ds.rmq.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfNodes {
    Set<Integer> set;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        set = new HashSet<>();
        for (TreeNode t : nodes) {
            set.add(t.value);
        }
        return helper(root);
    }

    private TreeNode helper(TreeNode node) { // recursive helper function

        if (node == null) {
            return null;
        }
        if (set.contains(node.value)) { // if we've reached a node of interest, return it
            return node;
        }
        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);

        if (left == null && right == null) { // none of this node's descendents are nodes of interest
            return null;
        } else if ((left != null) && (right != null)) { // this node is a common ancestor of two or more nodes of interest
            return node;
        } else if (left == null) { // left is null but right isn't
            return right;
        } else { // if right == null // right is null but left isn't
            return left;
        }
    }
}
