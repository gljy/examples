package leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		BinaryTreeRightSideView s = new BinaryTreeRightSideView();
		TreeNode root = new TreeNode("[1,2,3,null,5,null,4,6]");
		System.out.println(s.rightSideView(root));
	}

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			for (int i = 0, len = queue.size(); i < len; i++) {
				TreeNode node = queue.pollLast();
				if (i == 0) {
					res.add(node.val);
				}
				if (node.right != null) {
					queue.push(node.right);
				}
				if (node.left != null) {
					queue.push(node.left);
				}
			}
		}
		return res;
	}

}
