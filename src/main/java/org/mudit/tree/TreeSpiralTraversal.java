package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.Stack;

public class TreeSpiralTraversal {

    public static void main(String[] args) {
        treeSpiralTraversal(TreeNode.constructTree());

    }

    public static void treeSpiralTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        evenStack.add(root);
        int level = 0;
        while (!oddStack.isEmpty() || !evenStack.isEmpty()) {
            if (level % 2 == 0) {
                while (!evenStack.isEmpty()) {
                    TreeNode node = evenStack.pop();
                    if (node.right != null) {
                        oddStack.add(node.right);
                    }
                    if (node.left != null) {
                        oddStack.add(node.left);
                    }
                    System.out.print(node + " ");
                }
            } else {
                while (!oddStack.isEmpty()) {
                    TreeNode node = oddStack.pop();
                    if (node.left != null) {
                        evenStack.add(node.left);
                    }
                    if (node.right != null) {
                        evenStack.add(node.right);
                    }
                    System.out.print(node + " ");
                }
            }
            level++;
        }
    }
}
