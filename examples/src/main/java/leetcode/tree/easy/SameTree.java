package leetcode.tree.easy;

import common.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		SameTree s = new SameTree();
		TreeNode root = new TreeNode("[3,9,20,null,null,15,7]");
		System.out.println(s.isSameTree(root, root));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return p.val == q.val 
				&& isSameTree(p.left, q.left) 
				&& isSameTree(p.right, q.right);
	}

}
