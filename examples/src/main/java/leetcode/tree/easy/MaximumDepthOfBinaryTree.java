package leetcode.tree.easy;

import common.TreeNode;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree s = new MaximumDepthOfBinaryTree();
		TreeNode root = new TreeNode("[3,9,20,null,null,15,7]");
		System.out.println(s.maxDepth(root));
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
	}

}
