package leetcode.tree.easy;

import common.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree s = new BalancedBinaryTree();
		TreeNode root = new TreeNode("[3,9,20,null,null,15,7]");
		System.out.println(s.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return (Math.abs(height(root.left) - height(root.right)) <= 1) 
				&& isBalanced(root.left)
				&& isBalanced(root.right);

	}

	private int height(TreeNode root) {
		int height = 0;
		for (; root != null; root = root.left) {
			height++;
		}
		return height;
	}

}
