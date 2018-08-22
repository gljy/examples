package leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {
		PathSumII s = new PathSumII();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		s.pathSum(root, 22).forEach(System.out::println);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		pathSum(res, new ArrayList<>(), root, sum);;
		return res;
	}
	
	private void pathSum(List<List<Integer>> res, List<Integer> l, TreeNode node, int sum) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && sum == node.val) {
			res.add(l);
		}
		l.add(node.val);
		pathSum(res, new ArrayList<>(l), node.left, sum - node.val);
		pathSum(res, new ArrayList<>(l), node.right, sum - node.val);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
