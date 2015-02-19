package codingChallenge;

import java.util.Stack;

import util.TreeNode;

public class InorderSucc {

	// for general binary tree
	public static TreeNode insucc(TreeNode root, TreeNode key) {
		return insucc(root, key, null);
	}

	public static TreeNode insucc(TreeNode root, TreeNode key, TreeNode parent) {
		if (root == null)
			return null;
		if (root == key) {
			if (root.right != null)
				return findLeftMost(root.right);
			else
				return parent;
		}
		TreeNode left = insucc(root.left, key, root);
		if (left != null)
			return left;
		return insucc(root.right, key, parent);
	}

	// for binary search tree
	public static TreeNode insuccBST(TreeNode root, TreeNode key) {
		if (key.right != null)
			return findLeftMost(key.right);
		TreeNode succ = null;
		while (root != null) {
			if (key.val < root.val) {
				succ = root;
				root = root.left;
			} else if (key.val > root.val)
				root = root.right;
			else
				break;
		}
		return succ;
	}

	public static TreeNode findLeftMost(TreeNode root) {
		while (root.left != null)
			root = root.left;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		a.left = c;
		b.right = d;
		System.out.println(insucc(root, c).val);
	}

}
