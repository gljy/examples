package leetcode.sort.medium;

import common.ListNode;

public class SortList {

	public static void main(String[] args) {
		SortList s = new SortList();
		ListNode head = new ListNode("4->2->1->3");
		System.out.println(head);
		System.out.println(s.sortList(head));
	}

	public ListNode sortList(ListNode head) {
		ListNode root = new ListNode(0);
		while (head != null) {
			ListNode next = head.next, prev = root;
			while (prev.next != null && prev.next.val < head.val) {
				prev = prev.next;
			}
			
			head.next = prev.next;
			prev.next = head;
			head = next;
		}
		return root.next;
	}

}
