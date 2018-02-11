package Medium;

//304. Range Sum Query 2D - Immutable https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
public class RangeSumQuery2D {
	static class NumMatrix {

		private int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix.length == 0 || matrix[0].length == 0)
				return;
			dp = new int[matrix.length + 1][matrix[0].length + 1];
			for (int r = 0; r < matrix.length; r++) {
				for (int c = 0; c < matrix[0].length; c++) {
					dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		NumMatrix obj = new NumMatrix(matrix);

		/*
		 * sumRegion(1, 1, 2, 2) -> 11 sumRegion(1, 2, 2, 4) -> 12
		 */

		System.out.println(obj.sumRegion(2, 1, 4, 3));

	}
}
