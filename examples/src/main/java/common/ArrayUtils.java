package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayUtils {
	
	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static Pattern p = Pattern.compile("\\[([^(\\[|\\])]*)?\\]");

	// [["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]
	public static char[][] toCharArray(String input) {
		List<String> lines = new ArrayList<>();
		Matcher m = p.matcher(input);
		while (m.find()) {
			lines.add(m.group(1));
		}
		return lines.stream()
				.map(line -> line.replaceAll(",|\"", ""))
				.map(String::toCharArray)
				.toArray(char[][]::new);
	}
	
	public static int[][] toIntArray(String input) {
		List<String> lines = new ArrayList<>();
		Matcher m = p.matcher(input);
		while (m.find()) {
			lines.add(m.group(1));
		}
		return lines.stream()
				.map(line -> line.split(","))
				.map(ArrayUtils::strToInt)
				.toArray(int[][]::new);
	}
	
	private static int[] strToInt(String[] strs) {
		return Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
	}
	
}
