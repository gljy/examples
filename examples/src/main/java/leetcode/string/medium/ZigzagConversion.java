package leetcode.string.medium;

public class ZigzagConversion {

	public static void main(String[] args) {
		ZigzagConversion s = new ZigzagConversion();
		System.out.println(s.convert("PAYPALISHIRING", 3));
	}

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0, step = numRows + numRows - 2; i < numRows; i++) {
			for (int j = 0; i + j < s.length(); j += step) {
				res.append(s.charAt(i + j));
				if (i > 0 && i < numRows - 1 && j + step - i < s.length()) {
					res.append(s.charAt(j + step - i));
				}
			}
		}
		return res.toString();
	}

}
