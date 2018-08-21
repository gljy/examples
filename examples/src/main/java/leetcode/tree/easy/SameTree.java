package leetcode.tree.easy;

import leetcode.helper.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		SameTree s = new SameTree();

		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		System.out.println(s.isSameTree(node, node));
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
