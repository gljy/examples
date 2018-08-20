package leetcode.string.easy;

public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay s = new CountAndSay();
		for (int i = 1; i < 10; i++) {
			System.out.println(s.countAndSay(i));
		}
	}

	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}

		String str = countAndSay(n - 1) + "*";
		int count = 1;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				builder.append(count).append(str.charAt(i));
				count = 1;
			}
		}
		return builder.toString();
	}

}
