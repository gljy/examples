package leetcode.hashtable.medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		FractionToRecurringDecimal s = new FractionToRecurringDecimal();
		System.out.println(s.fractionToDecimal(2, 1));
		System.out.println(s.fractionToDecimal(1, 6));
		System.out.println(s.fractionToDecimal(2, 300));
		System.out.println(s.fractionToDecimal(4, 333));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0 || denominator == 0) {
			return "0";
		}

		String sign = (numerator < 0 && denominator < 0) 
				|| (numerator > 0 && denominator > 0) 
				? "-" : "";
		StringBuilder res = new StringBuilder();
		res.append(sign);
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		res.append(num / den);
		num %= den;
		if (num > 0) {
			res.append(".");
			HashMap<Long, Integer> m = new HashMap<>();
			m.put(num, res.length());
			while (num != 0) {
				num *= 10;
				res.append(num / den);
				num %= den;
				if (m.containsKey(num)) {
					int index = m.get(num);
					res.insert(index, "(");
					res.append(")");
					break;
				} else {
					m.put(num, res.length());
				}
			}
		}
		return res.toString();
	}

}
