package leetcode.math.medium;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		DivideTwoIntegers s = new DivideTwoIntegers();
		System.out.println(s.divide(1000000, 2));
	}

	public int divide(int dividend, int divisor) {
		int sign = dividend < 0 ? -1 : 1;
		sign *= (divisor < 0 ? -1 : 1);
		long res = divideLong(Math.abs((long) dividend), Math.abs((long) divisor));
		if (res > Integer.MAX_VALUE) {
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return sign * (int) res;
	}

	private long divideLong(long dividend, long divisor) {
		if (dividend < divisor) {
			return 0;
		}
		long sum = divisor;
		long multiple = 1;
		while (sum + sum <= dividend) {
			sum += sum;
			multiple += multiple;
		}
		return multiple + divideLong(dividend - sum, divisor);
	}

}
