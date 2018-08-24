package leetcode.dfs.medium;

import common.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode("[1,2,5,3,4,7,8]");
		s.flatten(root);
		System.out.println(root);
	}

	private TreeNode prev;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

}
