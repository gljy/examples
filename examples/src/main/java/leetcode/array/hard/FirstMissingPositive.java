package leetcode.array.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive s = new FirstMissingPositive();
		System.out.println(s.firstMissingPositive(new int[] { 1, 2, 0 }));
		System.out.println(s.firstMissingPositive(new int[] { 1, 2, 3 }));
		System.out.println(s.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		System.out.println(s.firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
	}

	public int firstMissingPositive(int[] nums) {
		int res = 0;
		/*nums = Arrays.stream(nums).distinct().sorted().toArray();
		for (int i = 0; i <= nums.length; i++) {
			if (i == nums.length) {
				res = res == 0 ? 1 : res + 1;
			} else if (nums[i] <= 0) {
				continue;
			} else if (++res < nums[i]) {
				break;
			}
		}*/
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
				swap(nums, i);
			}
		}
		for (int i = 0; i < nums.length && nums[i] == i + 1; i++) {
			res++;
		}
		return res + 1;
	}
	
	private void swap(int[] nums, int i) {
		int n = nums[i];
		while (n > 0 && n <= nums.length && n != nums[n - 1]) {
			int temp = nums[n - 1];
			nums[n - 1] = n;
			n = temp;
		}
	}

}
