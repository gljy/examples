package leetcode.tree.easy;

import leetcode.helper.TreeNode;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		BalancedBinaryTree s = new BalancedBinaryTree();
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		System.out.println(s.isBalanced(node));
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return (Math.abs(height(root.left) - height(root.right)) <= 1) 
				&& isBalanced(root.left)
				&& isBalanced(root.right);

	}

	private int height(TreeNode node) {
		int height = 0;
		for (; node != null; node = node.left) {
			height++;
		}
		return height;
	}

}
