package leetcode.dfs.medium;

import java.util.LinkedList;

import common.TreeNode;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		SumRootToLeafNumbers s = new SumRootToLeafNumbers();
		TreeNode root = new TreeNode("[4,9,0,5,1]");
		System.out.println(s.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.pop();
			if (node.left == null && node.right == null) {
				res += node.val;
				continue;
			}
			if (node.left != null) {
				node.left.val = node.val * 10 + node.left.val;
				queue.push(node.left);
			}
			if (node.right != null) {
				node.right.val = node.val * 10 + node.right.val;
				queue.push(node.right);
			}
		}
		return res;
	}

}
