package leetcode.sort.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.Interval;

public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval s = new InsertInterval();
		List<Interval> intervals = Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7),
				new Interval(8, 10), new Interval(12, 16));
		System.out.println(s.insert(new ArrayList<>(intervals), new Interval(4, 8)));
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.isEmpty()) {
			return Arrays.asList(newInterval);
		}

		Interval prev = null;
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (prev == null && ((i == intervals.size() - 1 && newInterval.start > interval.end)
					|| newInterval.end < interval.start)) {
				intervals.add(i + (newInterval.start > interval.end ? 1 : 0), newInterval);
				break;
			}
			if (prev == null && (newInterval.start <= interval.start || newInterval.start <= interval.end)) {
				interval.start = Math.min(interval.start, newInterval.start);
				interval.end = Math.max(interval.end, newInterval.end);
				prev = interval;
			} else if (prev != null && prev.end >= interval.start) {
				prev.end = Math.max(prev.end, interval.end);
				intervals.remove(i--);
			}
		}
		return intervals;
	}

}
