package org.mudit.tree;

import org.mudit.user_defined_data_structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxIteratively {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int findMaxItr(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.data > max) {
                max = n.data;
            }
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return max;
    }

    public int sumItr(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            sum += n.data;
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return sum;
    }
}
