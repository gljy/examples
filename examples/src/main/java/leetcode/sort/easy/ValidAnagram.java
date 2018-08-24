package leetcode.sort.easy;

public class ValidAnagram {

	public static void main(String[] args) {
		ValidAnagram s = new ValidAnagram();
		System.out.println(s.isAnagram("anagram", "nagaram"));
		System.out.println(s.isAnagram("rat", "car"));
	}

	public boolean isAnagram(String s, String t) {
		int[] array = new int[26];
		for (char ch : s.toCharArray()) {
			array[ch - 'a']++;
		}
		for (char ch : t.toCharArray()) {
			array[ch - 'a']--;
		}
		for (int i : array) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

}
