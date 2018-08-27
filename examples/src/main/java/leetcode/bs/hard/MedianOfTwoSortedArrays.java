package leetcode.bs.hard;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		MedianOfTwoSortedArrays s = new MedianOfTwoSortedArrays();
		
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			int[] temp = nums2;
			nums1 = nums2;
			nums2 = temp;
		}
		double res = findKth(nums1, nums2, 0, nums1.length, 0, nums2.length, (nums1.length + nums2.length) / 2);
		if ((nums1.length + nums2.length) % 2 == 0) {
			res = (res + findKth(nums1, nums2, 0, nums1.length, 0, nums2.length, (nums1.length + nums2.length) / 2) + 1)
					/ 2;
		}
		return res;
	}

	int findKth(int[] nums1, int[] nums2, int start1, int len1, int start2, int len2, int k) {
		int p = k / 2;
		int q = k - p;
		
		return 0;
	}

}
