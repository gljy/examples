package leetcode.tree.medium;

import java.util.Stack;

import common.TreeNode;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		ValidateBinarySearchTree s = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode("[5,1,7,null,null,6,8]");
		System.out.println(s.isValidBST(root));
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
