package leetcode.dynamicprogramming.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Note that you cannot sell a stock before you buy one.
 * 
 * @author guild
 * @date 2018.8.15
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock s = new BestTimeToBuyAndSellStock();
		System.out.println(s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(s.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 0, len = prices.length; i < len; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				res = Math.max(res, prices[j] - prices[i]);
			}
		}
		return res;
	}

}
