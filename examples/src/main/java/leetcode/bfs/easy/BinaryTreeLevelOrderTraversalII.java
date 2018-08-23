package leetcode.bfs.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
		TreeNode root = new TreeNode("[3,9,20,null,null,15,7]");
		System.out.println(s.levelOrderBottom(root));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.push(root);
		List<List<Integer>> res = new ArrayList<>();
		while (!queue.isEmpty()) {
			List<Integer> l = new ArrayList<>(queue.size());
			for (int i = 0, len = queue.size(); i < len; i++) {
				TreeNode node = queue.pollLast();
				l.add(node.val);
				if (node.left != null) {
					queue.push(node.left);
				}
				if (node.right != null) {
					queue.push(node.right);
				}
			}
			res.add(l);
		}
		Collections.reverse(res);
		return res;
	}

}
