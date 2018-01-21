package DynamicProgramming.Easy;

//121. Best Time to Buy and Sell Stock https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		Integer buyingPrice = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buyingPrice) {
				buyingPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - buyingPrice);
			}

		}
		return maxProfit;
	}
	
	//Leetcode
//	public class Solution {
//	    public int maxProfit(int prices[]) {
//	        int minprice = Integer.MAX_VALUE;
//	        int maxprofit = 0;
//	        for (int i = 0; i < prices.length; i++) {
//	            if (prices[i] < minprice)
//	                minprice = prices[i];
//	            else if (prices[i] - minprice > maxprofit)
//	                maxprofit = prices[i] - minprice;
//	        }
//	        return maxprofit;
//	    }
//	}
}
