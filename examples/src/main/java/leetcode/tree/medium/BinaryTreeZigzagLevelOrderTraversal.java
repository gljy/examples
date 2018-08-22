package leetcode.tree.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();

		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		node.right.left.left = new TreeNode(113);
		node.right.left.right = new TreeNode(114);
		s.zigzagLevelOrder(node).forEach(System.out::println);
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
