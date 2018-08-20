package leetcode.string.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix s = new LongestCommonPrefix();
		System.out.println(s.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println(s.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String common = strs[0];
		for (int i = 1; i < strs.length; i++) {
			common = digestCommonPrefix(common, strs[i]);
			if (common.isEmpty()) {
				break;
			}
		}
		return common;
	}

	private String digestCommonPrefix(String str1, String str2) {
		StringBuilder res = new StringBuilder();
		for (int i = 0, len = Math.min(str1.length(), str2.length()); i < len; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
			res.append(str1.charAt(i));
		}
		return res.toString();
	}

}
