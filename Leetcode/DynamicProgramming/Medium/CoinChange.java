package DynamicProgramming.Medium;

//322. Coin Change
/*// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1. */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);

				}
			}
		}
		if (dp[amount] == Integer.MAX_VALUE)
			return -1;
		else
			return dp[amount];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange c = new CoinChange();
		int[] coins = new int[] { 1, 2, 5 };
		int amount = 11;
		System.out.println(c.coinChange(coins, amount));

	}
}
