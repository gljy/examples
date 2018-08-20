package leetcode.string.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
		System.out.println(s.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
		System.out
				.println(s.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		if (s.isEmpty() || words.length == 0) {
			return Collections.emptyList();
		}

		HashMap<String, Integer> m = new HashMap<>();
		for (String word : words) {
			m.merge(word, 1, Math::addExact);
		}

		List<Integer> res = new ArrayList<>();
		int wordLen = words.length, wordStrLen = words[0].length();
		loop: for (int i = 0, len = s.length() - wordLen * wordStrLen; i <= len; i++) {
			HashMap<String, Integer> count = new HashMap<>(m);

			for (int j = i, k = 0; k < wordLen; k++, j += wordStrLen) {
				String word = s.substring(j, j + wordStrLen);
				int t = count.merge(word, -1, Math::addExact);
				if (t == -1) {
					continue loop;
				}
			}
			res.add(i);
		}
		return res;
	}

}
