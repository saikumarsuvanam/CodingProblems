package Medium;

//63. Unique Paths II https://leetcode.com/problems/unique-paths-ii/description/
/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.*/

//Note: m and n will be at most 100.
public class UniquepathsII {

	// APPROACH 1
	/// below solution has Time complexity o(mn) and space as o(mn)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int dp[][] = new int[m + 1][n + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				// if it has obstacel i.e 1, then store dp as 0.
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
					// if it is the end of the cell store dp as 1 as we reached
					// the end.
				} else if (i == m - 1 && j == n - 1) {
					dp[i][j] = 1;
				} else
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}

	// Approach 2
	// LeetCode time o(mn) space o(n)
	/*
	 * dp[j] += dp[j - 1]; is dp[j] = dp[j] + dp[j - 1]; which is new dp[j] =
	 * old dp[j] + dp[j-1] which is current cell = top cell + left cell
	 */

	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}
}
