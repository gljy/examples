package leetcode.tree.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
		List<TreeNode> nodes = s.generateTrees(4);
		nodes.forEach(System.out::println);
		
	}

	public List<TreeNode> generateTrees(int n) {
		return generateTrees(n, 0);
	}

	private List<TreeNode> generateTrees(int n, int offset) {
		if (n == 0) {
			return Collections.emptyList();
		}
		
		List<TreeNode> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			List<TreeNode> nodeLefts = generateTrees(i - 1, offset);
			List<TreeNode> nodeRights = generateTrees(n - i, offset + i);
			List<TreeNode> nodes = multiplyNodeLeftsAndRights(i + offset, nodeLefts, nodeRights);
			res.addAll(nodes);
		}
		return res;
	}
	
	private List<TreeNode> multiplyNodeLeftsAndRights(int nodeVal, List<TreeNode> nodeLefts, List<TreeNode> nodeRights) {
		List<TreeNode> res = new ArrayList<>();
		l: for (int j = 0; j <= nodeLefts.size(); j++) {
			r: for (int k = 0; k <= nodeRights.size(); k++) {
				TreeNode node = new TreeNode(nodeVal);
				if (!nodeLefts.isEmpty()) {
					if (j == nodeLefts.size()) {
						break l;
					}
					node.left = nodeLefts.get(j);
				}
				if (!nodeRights.isEmpty()) {
					if (k == nodeRights.size()) {
						break r;
					}
					node.right = nodeRights.get(k);
				}
				res.add(node);
			}
		}
		return res;
	}

}
