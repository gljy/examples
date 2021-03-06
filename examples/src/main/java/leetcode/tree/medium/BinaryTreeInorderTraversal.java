package leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode("[5,1,7,null,null,6]");
		System.out.println(s.inorderTraversal(root));
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
