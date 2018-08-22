package leetcode.tree.easy;

public class SymmetricTree {

	public static void main(String[] args) {
		SymmetricTree s = new SymmetricTree();

		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(3);
		System.out.println(s.isSymmetric(node));
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		return left.val == right.val
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}

}
