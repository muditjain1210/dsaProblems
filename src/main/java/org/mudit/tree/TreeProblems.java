package org.mudit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import UserDefinedDataStructures.TreeNode;

public class TreeProblems {
    public static int j = 0;
    public static int maxSum = 0;
    public ArrayList<Integer> rangeList = new ArrayList<Integer>();

    public static void main(String args[]) {

        TreeNode n2 = new TreeNode(2, null, null);
        TreeNode n3 = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(0, n2, n3);
        HashMap<Integer, Integer> map = new HashMap<>();

        sumNodeAtSameDistance(root, 0, map);
        System.out.println(map);
    }

    public int diameter(TreeNode root) {

        diameterHelper(root);
        int val = maxSum;
        maxSum = 0;
        return val;

    }

    static int findMin(BSTNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public void printRange(TreeNode root, int a, int b) {

        if (root == null) {
            return;
        }
        if (root.data >= b) {
            printRange(root.left, a, b);
        } else if (root.data <= a) {
            printRange(root.right, a, b);
        }
        if (root.data >= a && root.data <= b) {
            rangeList.add(root.data);
            printRange(root.left, a, b);
            printRange(root.right, a, b);
        }

    }

    public int diameterHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = diameterHelper(root.left);
        int rightSum = diameterHelper(root.right);

        int val = Math.max(1 + leftSum, 1 + rightSum);
        maxSum = Math.max(maxSum, 1 + leftSum + rightSum);
        return val;

    }

    public static ArrayList<Integer> levelorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.remove();

            if (n.left != null) {
                q.add(n.left);

            }

            if (n.right != null) {
                q.add(n.right);

            }
            al.add(n.data);
        }
        return al;
    }

    public static TreeNode findKthSmallest(TreeNode root, int k) {

        if (root == null || k == 0) {
            return root;
        }

        findKthSmallest(root.left, k);
        j++;
        if (j == k) {
            return root;
        }
        findKthSmallest(root.right, k);
        return root;
    }

    static int findMinRecursive(BSTNode root) {

        if (root.left != null) {
            return findMinRecursive(root.left);
        } else {
            return root.data;
        }

    }

    static BSTNode insert(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(null, null, data);
            return root;
        }
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void sumNodeAtSameDistance(TreeNode root, int dist, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(dist)) {
            map.put(dist, root.data);
        } else {
            int s = map.get(dist);
            map.put(dist, s + root.data);
        }
        sumNodeAtSameDistance(root.left, dist - 1, map);
        sumNodeAtSameDistance(root.right, dist + 1, map);

    }

    public static ArrayList<Integer> inorderItr(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();

        if (root == null) {
            return al;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode n = st.peek();

            if (n.left == null && n.right == null) {
                al.add(st.pop().data);
            } else if (n.left != null && !al.contains(n.left.data)) {
                st.push(n.left);
            } else {
                al.add(st.pop().data);
                if (n.right != null) {
                    st.push(n.right);
                }
            }

        }
        return al;
    }

    public static String serializeTree(TreeNode root) {
        StringBuilder b = new StringBuilder();
        return serializeTreeHelper(root, b).toString();

    }

    public static StringBuilder serializeTreeHelper(TreeNode root, StringBuilder b) {
        if (root == null) {
            b.append("*");
            b.append(",");
            return b;
        }
        b.append(root.data);
        b.append(",");
        serializeTreeHelper(root.left, b);
        serializeTreeHelper(root.right, b);
        return b;

    }

    public static TreeNode restoreTree(String str) {
        String[] strs = str.split(",");
        return restoreTreeHelper(strs);
    }

    public static int i = 0;

    public static TreeNode restoreTreeHelper(String[] arr) {

        if (i == arr.length || arr[i].equals("*")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]), null, null);
        ++i;
        root.left = restoreTreeHelper(arr);
        ++i;
        root.right = restoreTreeHelper(arr);
        return root;

    }
}

class BSTNode {
    BSTNode left;
    BSTNode right;
    int data;

    BSTNode(BSTNode left, BSTNode right, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode [left=" + left + ", right=" + right + ", data=" + data + "]";
    }

}