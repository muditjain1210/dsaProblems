package org.mudit.tree;



import java.util.Stack;

import UserDefinedDataStructures.TreeNode;

public class LCAInBST {

	public static void main(String[] args) {
		//Node lca = lca2(Node.constructTree(), 1, 7);
		//System.out.println(lca.data);
		System.out.println("sdfas");

	}

	// Lowest Commom Ancestor..

	static TreeNode lca(TreeNode root, int v1, int v2) {
		if (v1 == root.data || v2 == root.data) {
			return root;
		}
		if ((v1 < root.data && v2 > root.data) || (v1 > root.data && v2 < root.data)) {
			return root;
		}
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		searchnodeAndPreparePath(root, v1, st1);
		searchnodeAndPreparePath(root, v2, st2);

		while (true) {
			if (st1.peek() == root || st2.peek() == root) {
				return root;
			}
			if (st1.peek() == st2.peek()) {
				return st1.pop();
			} else {
				st1.pop();
				st2.pop();
			}
		}
	}

	static void searchnodeAndPreparePath(TreeNode root, int v1, Stack<TreeNode> st) {
		st.push(root);
		if (v1 == root.left.data || v1 == root.right.data) {
			return;
		}
		if (v1 < root.data) {
			searchnodeAndPreparePath(root.left, v1, st);
		} else {
			searchnodeAndPreparePath(root.right, v1, st);
		}
	}

	static TreeNode lca2(TreeNode root, int v1, int v2) {
		if (v1 > root.data && v2 > root.data) {
			return lca2(root.right, v1, v2);
		}
		if (v1 < root.data && v2 < root.data) {
			return lca2(root.left, v1, v2);
		}
		return root;
	}
}
