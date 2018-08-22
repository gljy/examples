package leetcode.tree.easy;

public class MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree s = new MaximumDepthOfBinaryTree();
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		System.out.println(s.maxDepth(node));
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
	}

}
