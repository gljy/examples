package leetcode.dfs.medium;

public class FlattenAMultilevelDoublyLinkedList {

	public static void main(String[] args) {
		FlattenAMultilevelDoublyLinkedList s = new FlattenAMultilevelDoublyLinkedList();
		Node node12 = new Node(12, null, null, null);
		Node node11 = new Node(11, null, node12, null);
		node12.prev = node11;
		
		Node node10 = new Node(10, null, null, null);
		Node node9 = new Node(9, null, node10, null);
		node10.prev = node9;
		Node node8 = new Node(8, null, node9, node11);
		node9.prev = node8;
		Node node7 = new Node(7, null, node8, null);
		node8.prev = node7;
		
		Node node6 = new Node(6, null, null, null);
		Node node5 = new Node(5, null, node6, null);
		node6.prev = node5;
		Node node4 = new Node(4, null, node5, null);
		node5.prev = node4;
		Node node3 = new Node(3, null, node4, node7);
		node4.prev = node3;
		Node node2 = new Node(2, null, node3, null);
		node3.prev = node2;
		Node node1 = new Node(1, null, node2, null);
		node2.prev = node1;
		Node node = s.flatten(node1);
//		Node node = node1;
		while (node != null) {
			System.out.println(node.val + "\t" + (node.prev != null ? node.prev.val : ""));
			node = node.next;
		}
	}
	
	private Node next;

	/*
	 * Example:
	 * Input: 
	 * 1---2---3---4---5---6---NULL 
	 *         | 
	 *         7---8---9---10--NULL 
	 *             | 
	 *             11--12--NULL
	 * Output: 
	 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
	 */
	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		flatten(head.next);
		flatten(head.child);
		head.next = next;
		if (next != null) {
			next.prev = head;
		}
		head.child = null;
		next = head;
		return next;
	}
	
	void flatten(Node head, Node prev) {
		if (head == null) {
			return;
		} else if (prev == null) {
			prev = head;
		}
		flatten(head.next);
		flatten(head.child);
		head.next = prev;
		prev = head;
	}

}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node() {
	}

	public Node(int _val, Node _prev, Node _next, Node _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}
};
