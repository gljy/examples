package leetcode.sort.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) {
		LongestWordInDictionaryThroughDeleting s = new LongestWordInDictionaryThroughDeleting();
		System.out.println(s.findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf")));
	}

	public String findLongestWord(String s, List<String> d) {
		if (d.isEmpty() || s.isEmpty()) {
			return "";
		}

		String res = d.stream().sorted(Comparator.comparing(String::valueOf))
                .sorted(Comparator.comparing(String::length).reversed())
				.filter(word -> match(s, word))
				.findFirst().orElse("");
		return res;
	}
	
	boolean match(String s, String v) {
		int z = 0;
		for (char ch : v.toCharArray()) {
			int index = s.indexOf(String.valueOf(ch), z);
			if (index == -1) {
				return false;
			}
			z = index + 1;
		}
		return true;
	}

}
