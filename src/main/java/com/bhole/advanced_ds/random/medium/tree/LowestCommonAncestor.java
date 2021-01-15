package com.bhole.advanced_ds.random.medium.tree;

import com.bhole.advanced_ds.rmq.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p == null || q == null) return null;

        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        tracePath(root, p, path1);
        tracePath(root, q, path2);

        //path1.stream().forEach(a-> System.out.println(a.val));
        //path2.stream().forEach(a-> System.out.println(a.val));
        int p1 = 0;
        int p2 = 0;
        TreeNode lca = null;
        while (p1<path1.size() && p2< path2.size()) {
            if (path1.get(p1) == path2.get(p2)) {
                lca = path1.get(p1);
            } else {
                break;
            }
            p1++;p2++;
        }
        return lca;
    }

    private boolean tracePath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root==null) return false;

        path.add(root);
        if (root == p) {
            return true;
        }

        boolean res = tracePath(root.left, p, path) || tracePath(root.right, p, path) ;

        if(!res) path.remove(root);

        return res;
    }

}
