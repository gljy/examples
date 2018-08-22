package leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(1);
		node.right = new TreeNode(7);
		node.right.left = new TreeNode(6);
		System.out.println(s.inorderTraversal(node));
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		
		Stack<TreeNode> s = new Stack<>();
		TreeNode n = root;
		do {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			
			n = s.pop();
			res.add(n.val);
			if (n.right != null) {
				n = n.right;
			} else {
				n = null;
			}
		} while (n != null || !s.isEmpty());
		return res;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) { 
		val = x; 
	}
}
