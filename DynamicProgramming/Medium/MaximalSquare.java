package Medium;

//221. Maximal Square https://leetcode.com/problems/maximal-square/description/
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//For example, given the following matrix:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Return 4. 
/*
 * In the previous approach for calculating dp of ithi^{th}i​th​​ row we are using only the previous element and the (i−1)th(i-1)^{th}(i−1)​th​​ row. Therefore, we don't need 2D dp matrix as 1D dp array will be sufficient for this.

Initially the dp array contains all 0's. As we scan the elements of the original matrix across a row, we keep on updating the dp array as per the equation dp[j]=min(dp[j−1],dp[j],prev)dp[j]=min(dp[j-1],dp[j],prev)dp[j]=min(dp[j−1],dp[j],prev), where prev refers to the old dp[j−1]dp[j-1]dp[j−1]. For every row, we repeat the same process and update in the same dp array.
 */
//Complexity Analysis
//
//Time complexity : O(mn)O(mn)O(mn). Single pass.
//
//Space complexity : O(n)O(n)O(n). Another array which stores elements in a row is used for dp.

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int[] dp = null;
		if (matrix.length > 0) {
			dp = new int[matrix[0].length + 1];
		}
		int maxarea = 0;
		int prev = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int temp = dp[j + 1];
				if (matrix[i][j] == '1') {
					dp[j + 1] = Math.min(Math.min(prev, dp[j + 1]), dp[j]) + 1;
					maxarea = Math.max(maxarea, dp[j + 1]);
				} else {
					dp[j + 1] = 0;
				}
				prev = temp;

			}
		}
		return maxarea * maxarea;
	}
}
