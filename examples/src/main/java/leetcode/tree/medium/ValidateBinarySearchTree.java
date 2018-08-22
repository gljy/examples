package leetcode.tree.medium;

import java.util.Stack;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		ValidateBinarySearchTree s = new ValidateBinarySearchTree();

		
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(8);
		
		System.out.println(s.isValidBST(node));
		System.out.println(s.isValidBST(null));
		
		node = new TreeNode(2);
		node.left = new TreeNode(1);
		node.right = new TreeNode(3);
		System.out.println(s.isValidBST(node));
	}

	public boolean isValidBST(TreeNode root) {
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
