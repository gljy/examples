package leetcode.math.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber s = new PalindromeNumber();
		System.out.println(s.isPalindrome(121));
		System.out.println(s.isPalindrome(42524));
		System.out.println(s.isPalindrome(425246));
		System.out.println(s.isPalindrome(121121));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		String v = String.valueOf(x);
		boolean res = true;
		for (int l = 0, r = v.length() - 1; l < r; l++, r--) {
			if (v.charAt(l) != v.charAt(r)) {
				res = false;
				break;
			}
		}
		return res;
	}

}
