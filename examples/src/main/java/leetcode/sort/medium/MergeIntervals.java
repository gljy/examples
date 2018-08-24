package leetcode.sort.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals s = new MergeIntervals();
		List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(7, 16), new Interval(2, 6),
				new Interval(8, 10), new Interval(7, 9), new Interval(15, 18));
		intervals = s.merge(intervals);
		System.out.println(intervals);
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return Collections.emptyList();
		}
		
		Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
		List<Interval> res = new ArrayList<>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (prev.end < interval.start) {
				res.add(prev);
				prev = interval;
			} else {
				prev.end = Math.max(prev.end, interval.end);
			}
		}
		res.add(prev);
		return res;
	}

}
