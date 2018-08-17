package leetcode.dynamicprogramming.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * @author guild
 * @date 2018.8.17
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring s = new LongestPalindromicSubstring();
		System.out.println(s.longestPalindrome("babad"));
		System.out.println(s.longestPalindrome("cbbd"));
	}

	/*
	 * Example 1:
	 * Input: "babad"
	 * Output: "bab"
	 * Note: "aba" is also a valid answer.
	 * 
	 * Example 2:
	 * Input: "cbbd"
	 * Output: "bb"
	 */
	public String longestPalindrome(String s) {
		String res = "";
		for (int i = 0, n = 0, len = s.length(); i < len; i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (n < j - i && isPalindromic(s, i, j - 1)) {
					n = j - i;
					res = s.substring(i, j);
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
