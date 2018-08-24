package common;

public class ListNode {
	
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public ListNode(String input) {
		String[] arr = input.split("->");
		val = Integer.parseInt(arr[0]);
		ListNode prev = null;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(Integer.parseInt(arr[i]));
			if (prev == null) {
				next = node;
			} else {
				prev.next = node;
			}
			prev = node;
		}
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
