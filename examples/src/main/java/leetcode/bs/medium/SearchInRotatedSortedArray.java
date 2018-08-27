package leetcode.bs.medium;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
//		System.out.println(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
//		System.out.println(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(s.search(new int[] { 5, 1, 2, 3, 4 }, 1));
	}

	public int search(int[] nums, int target) {
		int len = nums.length;
		if (len < 5) {
			for (int i = 0; i < len; i++) {
				if (nums[i] == target) {
					return i;
				}
			}
		} else {
			int l = 0, r = len - 1, rindex = -1;
			while (l <= r) {
				int mid = (l + r) / 2;
				if ((mid == 0 || (mid > 0 && nums[mid] > nums[mid - 1])) 
						&& (mid == len - 1 || (mid < len - 1 && nums[mid] > nums[mid + 1]))) {
					rindex = mid;
					break;
				} else if (nums[mid] < nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			if (rindex != -1) {
				rindex = binarySearch(nums, nums[0] <= target ? 0 : rindex + 1, nums[0] <= target ? rindex : len - 1, target);
			} else {
				rindex = binarySearch(nums, 0, len - 1, target);
			}
			return rindex;
		}
		return -1;
	}
	
	int binarySearch(int[] nums, int l, int r, int target) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

}
