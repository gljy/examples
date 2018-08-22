package leetcode.hashtable.medium;

public class BullsAndCows {

	public static void main(String[] args) {
		BullsAndCows s = new BullsAndCows();
		// 1A3B
		System.out.println(s.getHint("1807", "7810"));
		// 1A1B
		System.out.println(s.getHint("1122", "1222"));
	}

	public String getHint(String secret, String guess) {
		int[] sarr = new int[10], garr = new int[10];
		int a = 0;
		for (int i = 0, len = secret.length(); i < len; i++) {
			char sch = secret.charAt(i), gch = guess.charAt(i);
			if (sch == gch) {
				a++;
			} else {
				sarr[Character.getNumericValue(sch)] += 1;
				garr[Character.getNumericValue(gch)] += 1;
			}
		}
		int b = 0;
		for (int i = 0; i < 10; i++) {
			b += Math.min(sarr[i], garr[i]);
		}
		return a + "A" + b + "B";
	}

}
