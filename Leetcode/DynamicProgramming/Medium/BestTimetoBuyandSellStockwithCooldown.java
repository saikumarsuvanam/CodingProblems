package DynamicProgramming.Medium;
//309. Best Time to Buy and Sell Stock with Cooldown https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

 * 
 */
public class BestTimetoBuyandSellStockwithCooldown {
	
	
	
	//Hint -http://buttercola.blogspot.com/2016/01/leetcode-best-time-to-buy-and-sell.html
	//o(1) space and o(n) time
	public class Solution {
	    public int maxProfit(int[] prices) {
	        if (prices == null || prices.length <= 1) {
	            return 0;
	        }
	         
	        int b1 = -prices[0];
	         
	        int s2 = 0;
	        int s1 = 0;
	         
	        for (int i = 1; i <= prices.length; i++) {
	            int b0 = Math.max(b1, s2 - prices[i - 1]);
	            int s0 = Math.max(s1, b1 + prices[i - 1]);
	             
	            b1 = b0;
	            s2 = s1;
	            s1 = s0;
	        }
	         
	        return s1;
	    }
	}
	
	
	
	
	//o(n*n) time and o(2n) space
	public int maxProfit(int[] prices) {

		int[] dp = new int[prices.length];
		int maxprofit = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {

				int buy = prices[j];
                int sell=prices[i];
				if (sell>buy) {
					dp[i] = (j - 2) >= 0 ? Math.max(dp[i], sell-buy+ findmax(dp,j-2))
							: Math.max(dp[i], sell-buy);
				}

			}
			maxprofit = Math.max(maxprofit, dp[i]);
		}
		return maxprofit;

	}
	
	
	int findmax(int [] dp, int index){
		int max=0;
		for(int i=0;i<=index;i++){
			max=Math.max(dp[i], max);
		}
		return max;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BestTimetoBuyandSellStockwithCooldown b=new BestTimetoBuyandSellStockwithCooldown();
		
		int prices[]=new int []{6,1,6,4,3,0,2};
		System.out.println(b.maxProfit(prices));
	}

}
