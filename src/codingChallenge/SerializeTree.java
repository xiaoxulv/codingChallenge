package codingChallenge;

import util.TreeNode;

public class SerializeTree {
	public static String serialize(TreeNode root){
		String res = "";
		if(root == null){
			res += "-1" + " ";
			return res;
		}
		res += root.val + " ";
		res += serialize(root.left);
		res += serialize(root.right);
//		System.out.println(res);
		return res;
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
		String res = "";
		
		System.out.println(serialize(root));
	}

}
