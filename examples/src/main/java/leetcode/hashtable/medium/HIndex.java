package leetcode.hashtable.medium;

public class HIndex {

	public static void main(String[] args) {
		HIndex s = new HIndex();
		System.out.println(s.hIndex(new int[] { 3, 0, 6, 1, 5 }));
	}

	/* 3 0 6 4 5
	 * h 指数的定义: “一位有 h 指数的学者，代表他（她）的 N 篇论文中至多有 h 篇论文，分别被引用了至少 h 次，其余的 N - h 篇论文每篇被引用次数不多于 h 次。”
	 */
	public int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		
		int h = 0;
		for (int i = citations.length; i >= 0; i--) {
			int count = 0, count2 = 0;
			for (int j : citations) {
				if (j >= i) {
					count++;
				}
				if (j <= i) {
					count2++;
				}
			}
			
			if (count >= i && count2 + i >= citations.length) {
				h = Math.max(h, i);
			}
		}
		return h;
	}

}
