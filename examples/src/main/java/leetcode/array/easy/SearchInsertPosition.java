package leetcode.array.easy;

public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		System.out.println(s.searchInsert(new int[] { -4, -3, -1, 1, 3, 5, 6 }, 2));
	}

	public int searchInsert(int[] nums, int target) {
		if (nums[0] >= target) {
			return 0;
		}
		if (nums[nums.length - 1] < target) {
			return nums.length;
		}
		
		int l = 0, r = nums.length - 1;
		while (r >= l) {
			int m = nums[(r + l) / 2];
			if (m == target) {
				return (r + l) / 2;
			}
			if (m > target) {
				r--;
			} else {
				l++;
			}
		}
		return (r + l + 1) / 2;
	}

}
