package codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

public class printTree {
	public static void print(TreeNode root){
		if(root == null)
			System.out.println("oh no, null here");
		Queue<TreeNode> queue= new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int s = queue.size();
			//System.out.println("size " + s);
			for (int i = 0; i < s; i++) {
				TreeNode t = queue.poll();
				System.out.print(t.val);
				System.out.print(' ');
				if (t.left != null)
					queue.add(t.left);
				if (t.right != null)
					queue.add(t.right);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(8);
		TreeNode d = new TreeNode(9);
		root.left = a;
		root.right = b;
		a.right = c;
		b.right = d;
		print(root);
	}

}
