package leetcode.helper;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("[" + val);
		if (left != null) {
			res.append(", left=" + left);
		}
		if (right != null) {
			res.append(", right=" + right);
		}
		res.append("]");
		return res.toString();
	}

}
