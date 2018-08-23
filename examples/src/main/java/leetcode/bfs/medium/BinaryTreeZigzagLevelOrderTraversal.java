package leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = new TreeNode("[3,9,20,12,13,15,7]");
		System.out.println(s.zigzagLevelOrder(root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>();
		zigzagLevelOrder(res, Arrays.asList(root), 1);
		return res;
	}

	void zigzagLevelOrder(List<List<Integer>> res, List<TreeNode> roots, int sign) {
		if (roots.isEmpty()) {
			return;
		}

		List<TreeNode> roots2 = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		for (int i = 0, len = roots.size(); i < len; i++) {
			l.add(roots.get(sign == -1 ? len - 1 - i : i).val);
			TreeNode root = roots.get(i);
			if (root.left != null) {
				roots2.add(root.left);
			}
			if (root.right != null) {
				roots2.add(root.right);
			}
		}
		res.add(l);
		zigzagLevelOrder(res, roots2, sign * -1);
	}

}
