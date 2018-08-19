package leetcode.string.medium;

public class StringToInteger {

	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		System.out.println(s.myAtoi("42"));
		System.out.println(s.myAtoi("    -42"));
		System.out.println(s.myAtoi("4193 with words"));
		System.out.println(s.myAtoi("words and 987"));
		System.out.println(s.myAtoi("-91283472332"));
		System.out.println(s.myAtoi("20000000000000000000"));
		System.out.println(s.myAtoi("-20000000000000000000"));
		System.out.println(s.myAtoi("  0000000000012345678"));
	}
	
	public int myAtoi(String str) {
		if ((str = str.trim()).isEmpty()) {
			return 0;
		}
		int sign = 1;
		int index = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			index++;
		} else if (str.charAt(0) == '+') {
			index++;
		}
		long sum = 0;
		for (int i = index; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			} else {
				sum = sum * 10 + str.charAt(i) - '0';
				if (sign == 1 && sum > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (sign == -1 && sum * sign < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
		}
		return (int) sum * sign;
	}

}
