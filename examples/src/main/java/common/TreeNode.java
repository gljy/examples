package common;

import java.util.LinkedList;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public TreeNode(String input) {
		String[] arr = input.substring(1, input.length() - 1).split(",");
		val = Integer.parseInt(arr[0]);
		
		LinkedList<TreeNode> stack = new LinkedList<>();
		stack.add(this);
		int j = 1;
		while (!stack.isEmpty() && j < arr.length) {
			for (int i = 0, len = stack.size(); i < len; i++) {
				TreeNode node = stack.pollLast();
				if (j < arr.length) {
					String v = arr[j++];
					if (!"null".equals(v)) {
						node.left = new TreeNode(Integer.parseInt(v));
						stack.push(node.left);
					}
				}
				if (j < arr.length) {
					String v = arr[j++];
					if (!"null".equals(v)) {
						node.right = new TreeNode(Integer.parseInt(v));
						stack.push(node.right);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}
