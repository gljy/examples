package leetcode.tree.easy;

import common.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();
		TreeNode root = new TreeNode("[1,2,2,3,4,4,3]");
		System.out.println(s.isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}

}
