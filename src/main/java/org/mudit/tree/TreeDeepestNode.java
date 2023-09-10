package org.mudit.tree;

import java.util.LinkedList;
import java.util.Queue;

import UserDefinedDataStructures.TreeNode;

/**
 * Given a binary tree, write a method to find and return its deepest node.
 * Return null for an empty tree.
 * 
 * @author jainm15
 *
 */
public class TreeDeepestNode {

    public static void main(String[] args) {
        findDeepest(TreeNode.constructTree());

    }

    public static TreeNode findDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode node = null;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }

        }
        System.out.println(node);
        return node;
    }
}
