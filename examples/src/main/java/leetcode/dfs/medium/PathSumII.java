package leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class PathSumII {

	public static void main(String[] args) {
		PathSumII s = new PathSumII();
		TreeNode root = new TreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
		s.pathSum(root, 22).forEach(System.out::println);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		pathSum(res, new ArrayList<>(), root, sum);
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
