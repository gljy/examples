package leetcode.backtracking.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryWatch {

	public static void main(String[] args) {
		BinaryWatch s = new BinaryWatch();
		System.out.println(s.readBinaryWatch(2));
	}
	
	public List<String> readBinaryWatch(int num) {
		final int[] hours = { 1, 2, 4, 8 };
		final int[] minutes = { 1, 2, 4, 8, 16, 32 };
		if (num > hours.length - 1 + minutes.length - 1) {
			return Collections.emptyList();
		}

		List<String> res = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			if (num - i > minutes.length - 1 || i > hours.length - 1) {
				continue;
			}
			List<String> hourstrs = readBinaryWatch(hours, i)
					.stream()
					.filter(hour -> hour <= 11)
					.map(String::valueOf)
					.collect(Collectors.toList());
			List<String> minutestrs = readBinaryWatch(minutes, num - i)
					.stream()
					.filter(minute -> minute <= 59)
					.map(minute -> (minute <= 9 ? "0" : "") + minute)
					.collect(Collectors.toList());
			for (String hourstr : hourstrs) {
				for (String minutestr : minutestrs) {
					if (!res.contains(hourstr + ":" + minutestr)) {
						res.add(hourstr + ":" + minutestr);
					}
				}
			}
		}
		return res;
	}

	private List<Integer> readBinaryWatch(int[] nums, int len) {
		if (len == 0) {
			List<Integer> res = new ArrayList<>();
			res.add(0);
			return res;
		}

		List<Integer> res = new ArrayList<>();
		readBinaryWatch(res, 0, nums, len);
		return res;
	}

	private void readBinaryWatch(List<Integer> res, int cache, int[] nums, int len) {
		if (len == 0) {
			res.add(cache);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			readBinaryWatch(res, cache + nums[i], copyAndRemoveArray(nums, i), len - 1);
		}
	}

	private int[] copyAndRemoveArray(int[] nums, int index) {
		int[] res = new int[nums.length - 1];
		if (res.length > 0) {
			if (index > 0) {
				System.arraycopy(nums, 0, res, 0, index);
			}
			if (index < nums.length - 1) {
				System.arraycopy(nums, index + 1, res, index, nums.length - 1 - index);
			}
		}
		return res;
	}

}
