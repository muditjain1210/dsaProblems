package org.mudit.tree;

import java.util.LinkedList;
import java.util.Queue;

import UserDefinedDataStructures.TreeNode;

public class TreeHeightORDepth {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int minTreeDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minTreeDepthRecursive(root.left), minTreeDepthRecursive(root.right));
    }

    public int treeHeightRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(treeHeightRecursive(root.left), treeHeightRecursive(root.right));
    }

    public static int minTreeDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNodeDepth> q = new LinkedList<>();
        q.add(new TreeNodeDepth(root, 1));

        while (!q.isEmpty()) {
            TreeNodeDepth nodeWithDepth = q.poll();

            if (nodeWithDepth.node.left == null && nodeWithDepth.node.right == null) {
                // first leaf node
                minDepth = nodeWithDepth.depth;
                break;
            }

            if (nodeWithDepth.node.left != null) {
                q.add(new TreeNodeDepth(nodeWithDepth.node.left, nodeWithDepth.depth + 1));
            }
            if (nodeWithDepth.node.right != null) {
                q.add(new TreeNodeDepth(nodeWithDepth.node.right, nodeWithDepth.depth + 1));
            }

        }
        return minDepth;
    }

}

class TreeNodeDepth {
    TreeNode node;
    int depth;

    public TreeNodeDepth(TreeNode node, int depth) {
        super();
        this.node = node;
        this.depth = depth;
    }
}