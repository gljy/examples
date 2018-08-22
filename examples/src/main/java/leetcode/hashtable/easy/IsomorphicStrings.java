package leetcode.hashtable.easy;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings s = new IsomorphicStrings();
		System.out.println(s.isIsomorphic("egg", "add"));
		System.out.println(s.isIsomorphic("foo", "bar"));
		System.out.println(s.isIsomorphic("ab", "aa"));
		System.out.println(s.isIsomorphic("paper", "title"));
		
	}
	
	public boolean isIsomorphic(String s, String t) {
		int[] m = new int[256 * 2];
		for (int i = 0; i < s.length(); i++) {
			if (m[s.charAt(i)] != m[t.charAt(i) + 256]) {
				return false;
			}
			m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
		}
		return true;
	}

}
