package leetcode.array.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater s = new ContainerWithMostWater();
		System.out.println(s.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int res = 0;
		while (l < r) {
			res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}

}
