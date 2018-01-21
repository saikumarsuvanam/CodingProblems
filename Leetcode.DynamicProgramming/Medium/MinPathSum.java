package Medium;

//64. Minimum Path Sum https://leetcode.com/problems/minimum-path-sum/description/
/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

[[1,3,1],
 [1,5,1],
 [4,2,1]]

Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum. 
 */
public class MinPathSum {

	// Approach 1
	// Better Solution with o(n) space complexity and time -o(mn)
	public int minPathSum1(int[][] grid) {

		//use only one dimension which is column length find the min of current,old value+grid[i][j]
		int dp[] = new int[grid[0].length + 1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0) {
					dp[j + 1] = grid[i][j] + dp[j];
				} else if (j == 0) {
					dp[j + 1] = grid[i][j] + dp[j + 1];
				} else
					dp[j + 1] = grid[i][j] + Math.min(dp[j + 1], dp[j]);
			}
		}
		return dp[grid[0].length];

	}

	// Approach 2
	// space-o(mn)
	public int minPathSum(int[][] grid) {

		int dp[][] = new int[grid.length + 1][grid[0].length + 1];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0) {
					dp[i + 1][j + 1] = grid[i][j] + dp[i + 1][j];
				} else if (j == 0) {
					dp[i + 1][j + 1] = grid[i][j] + dp[i][j + 1];
				} else
					dp[i + 1][j + 1] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		return dp[grid.length][grid[0].length];

	}
}
