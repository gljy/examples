package leetcode.tree.hard;

import java.util.Stack;

import common.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		RecoverBinarySearchTree s = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode("[3,1,4,null,null,2]");
		System.out.println(root);
		s.recoverTree(root);
		System.out.println(root);
	}

	public void recoverTree(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode n = root;
		TreeNode v = new TreeNode(Integer.MIN_VALUE);
		while (!s.isEmpty() || n != null) {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			n = s.pop();
			if (v.val >= n.val) {
				int temp = v.val;
				v.val = n.val;
				n.val = temp;
				recoverTree(root);
			}
			v = n;
			if (n.right != null) {
				n = n.right;
			} else {
				n = null;
			}
		}
	}

}
