package leetcode.dfs.medium;

import java.util.LinkedList;
import java.util.Stack;

public class PopulatingNextRightPointersInEachNodeII {

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNodeII s = new PopulatingNextRightPointersInEachNodeII();

		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(7);
		s.connect(root);

		Stack<TreeLinkNode> stack = new Stack<>();
		TreeLinkNode n = root;
		do {
			while (n != null) {
				stack.push(n);
				n = n.left;
			}

			n = stack.pop();
			System.out.println(n.val + "\t" + (n.next != null ? n.next.val : "null"));
			if (n.right != null) {
				n = n.right;
			} else {
				n = null;
			}
		} while (n != null || !stack.isEmpty());
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		LinkedList<TreeLinkNode> stack = new LinkedList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeLinkNode prev = null;
			for (int i = 0, len = stack.size(); i < len; i++) {
				TreeLinkNode node = stack.pollLast();
				node.next = prev;
				prev = node;
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
	}

}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
