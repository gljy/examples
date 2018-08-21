package leetcode.tree.hard;

import java.util.Stack;

import leetcode.helper.TreeNode;

public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		RecoverBinarySearchTree s = new RecoverBinarySearchTree();
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		node.right.left = new TreeNode(2);
		System.out.println(node);
		s.recoverTree(node);
		System.out.println(node);
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
	
	boolean isValidBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode n = root;
		long v = Long.MIN_VALUE;
		while (!s.isEmpty() || n != null) {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			n = s.pop();
			System.out.println(n.val + "\t" + v + "\t" + (v >= n.val));
			if (v >= n.val) {
				return false;
			}
			v = n.val;
			if (n.right != null) {
				n = n.right;
			} else {
				n = null;
			}
		}
		return true;
	}

}
