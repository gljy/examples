package leetcode.array.medium;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame s = new JumpGame();
		System.out.println(s.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(s.canJump(new int[] { 3, 2, 1, 0, 4 }));
	}

	public boolean canJump(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (res < i) {
				break;
			}
			res = Math.max(res, nums[i] + i);
		}
		return res >= nums.length - 1;
	}
	
}
