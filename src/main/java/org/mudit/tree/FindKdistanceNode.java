package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.*;

public class FindKdistanceNode {

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTree();
        System.out.println(findKdistanceNodesfromANode(root, 4, 3));
    }

    public static List<TreeNode> findKdistanceNodesfromANodeUsingMap(TreeNode root, int node, int k) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        // First we will prepare a HashMap from this tree, this map will have node(data) as key
        // and its adjacent nodes as values..(including parent node)
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        return null;
    }

    public static void findKdistanceDownNodesfromThisTree(TreeNode root, int k, int initaldistance, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        if (initaldistance == k) {
            result.add(root);
            return;
        }
        findKdistanceDownNodesfromThisTree(root.left, k, initaldistance + 1, result);
        findKdistanceDownNodesfromThisTree(root.right, k, initaldistance + 1, result);
    }

    // NOT working!!
    public static List<TreeNode> findKdistanceNodesfromANode(TreeNode root, int node, int k) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }

        if (root.data == node) {
            // root is the node
            findKdistanceDownNodesfromThisTree(root, k, 0, result);
            return result;

        } else {
            // Find node's parent node first..
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    if (temp.left.data == node) {
                        findKdistanceDownNodesfromThisTree(temp.left, k, 0, result);
                        findKdistanceDownNodesfromThisTree(temp, k - 1, 0, result);
                        break;
                    }
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    if (temp.right.data == node) {
                        findKdistanceDownNodesfromThisTree(temp.right, k, 0, result);
                        findKdistanceDownNodesfromThisTree(temp, k - 1, 0, result);
                        break;
                    }
                    q.add(temp.right);
                }
            }
            return result;
        }
    }
}
