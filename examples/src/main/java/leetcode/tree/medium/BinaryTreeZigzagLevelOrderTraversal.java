package leetcode.tree.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode("[3,9,20,null,null,15,7]");
		s.zigzagLevelOrder(root).forEach(System.out::println);
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> res = new LinkedList<>();
		zigzagLevelOrder(res, Arrays.asList(root), 1);
		return res;
	}

	private void zigzagLevelOrder(List<List<Integer>> res, List<TreeNode> nodes, int sign) {
		List<TreeNode> nextNodes = new LinkedList<>();
		List<Integer> subs = new LinkedList<>();
		for (int i = 0, len = nodes.size(); i < len; i++) {
			TreeNode node = nodes.get(sign == 1 ? i : len - 1 - i);
			subs.add(node.val);
			if (node.left != null) {
				nextNodes.add(node.left);
			}
			if (node.right != null) {
				nextNodes.add(node.right);
			}
		}
		res.add(subs);
		if (!nextNodes.isEmpty()) {
			zigzagLevelOrder(res, nextNodes, sign * -1);
		}
	}

}
