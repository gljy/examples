package leetcode.array.hard;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII s = new JumpGameII();
		System.out.println(s.jump(new int[] { 2, 3, 1, 1, 4 }));
	}

	public int jump(int[] nums) {
		int res = 0;
		int curr = 0, last = 0;
		for (int i = 0; i < nums.length; i++) {
			if (curr < i) {
				return -1;
			}
			if (i > last) {
				last = curr;
				res++;
			}
			curr = Math.max(curr, nums[i] + i);
		}
		return res;
	}
	
}
