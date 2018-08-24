package leetcode.sort.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WiggleSortII {

	public static void main(String[] args) {
		WiggleSortII s = new WiggleSortII();
		int[] nums = new int[] { 5, 3, 1, 2, 6, 7, 8, 5, 5 };
		s.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));


		int[] nums1 = { 1, 10, 20, 20, 10, 1 };
		int[] nums2 = { 10, 20 };
		Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums2) {
            m.merge(i, 1, Math::addExact);
        }
        int[] nums3 = Arrays.stream(nums1).filter(i -> {
			Integer v = m.computeIfPresent(i, (t, u) -> u - 1);
			return v != null && v >= 0;
		}).toArray();;
		System.out.println(Arrays.toString(nums3));
	}

	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0, len = nums.length, m = len / 2, r = len % 2; i < m; i++) {
			int temp1 = nums[m - 1 + i + r], temp2 = nums[len - 1];
			System.arraycopy(nums, len - m + i, nums, len - m + i + 1, m - 1 - i);
			System.arraycopy(nums, i * 2, nums, (i + 1) * 2, m - 1 - i + r);
			nums[i * 2] = temp1;
			nums[i * 2 + 1] = temp2;
		}
	}

}
