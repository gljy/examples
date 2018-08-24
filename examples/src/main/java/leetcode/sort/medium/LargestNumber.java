package leetcode.sort.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber s = new LargestNumber();
		System.out.println(s.largestNumber(new int[] { 3, 30, 34, 5, 9 })); // 9534330

	}

	public String largestNumber(int[] nums) {
		String res = Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.sorted(this::compare)
				.collect(Collectors.joining());
		return res.startsWith("0") ? "0" : res;
	}

	int compare(String a, String b) {
		if (a.equals(b)) {
			return 0;
		}
		if (a.length() == b.length()) {
			return Integer.parseInt(a) > Integer.parseInt(b) ? -1 : 1;
		}

		int sign = 1;
		if (a.length() < b.length()) {
			String tmp = a;
			a = b;
			b = tmp;
			sign = -1;
		}
		int res = compare(a.substring(0, b.length()), b);
		if (res == 0) {
			res = compare(a.substring(b.length()), b);
		}
		return res * sign;
	}

}
