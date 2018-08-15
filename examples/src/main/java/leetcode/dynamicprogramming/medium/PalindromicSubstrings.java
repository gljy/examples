package leetcode.dynamicprogramming.medium;

/**
 * Given a string, your task is to count how many palindromic substrings in this
 * string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class PalindromicSubstrings {

	public static void main(String[] args) {
		PalindromicSubstrings s = new PalindromicSubstrings();
		System.out.println(s.countSubstrings("ababa"));
	}

	public int countSubstrings(String s) {
		int res = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (isPalindromic(s, i, j - 1)) {
					res++;
				}
			}
		}
		return res;
	}
	
	private boolean isPalindromic(String s, int left, int right) {
		while (right > left && s.charAt(left) == s.charAt(right)) {
			left++; 
			right--;
		}
		return right <= left;
	}

}
