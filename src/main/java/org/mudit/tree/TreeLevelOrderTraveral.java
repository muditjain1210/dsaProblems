package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraveral {

    public static void main(String[] args) {

        // levelOrderTraversal(TreeNode.constructTree());
        levelOrderWithArrayListOfList(TreeNode.constructTree());
    }

    static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        if (root != null) {
            qu.add(root);
        }
        while (!qu.isEmpty()) {
            TreeNode n = qu.poll();
            System.out.print(n.data + " ");
            if (n.left != null) {
                qu.add(n.left);
            }
            if (n.right != null) {
                qu.add(n.right);
            }

        }

    }

    static ArrayList<ArrayList<Integer>> levelOrderWithArrayListOfList(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while (!qu.isEmpty()) {
            ArrayList<TreeNode> list = new ArrayList<>();
            // empty nodes from the queue for the current level
            while (!qu.isEmpty()) {
                list.add(qu.poll());
            }
            ArrayList<Integer> list2 = new ArrayList<>();
            for (TreeNode n : list) {
                list2.add(n.data);
                if (n.left != null) {
                    qu.add(n.left);
                }
                if (n.right != null) {
                    qu.add(n.right);
                }
            }
            result.add(list2);
        }
        System.out.println(result);
        return result;
    }

    static void connectSiblings(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        if (root != null) {
            qu.add(root);
        }
        while (!qu.isEmpty()) {
            TreeNode n = qu.poll();
            System.out.println(n.data + " ");
            if (n.left != null) {
                qu.add(n.left);
            }
            if (n.right != null) {
                qu.add(n.right);
            }

        }

    }

}
