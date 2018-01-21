package Medium;

import java.util.Arrays;
//688. Knight Probability in Chessboard
//https://leetcode.com/problems/knight-probability-in-chessboard/discuss/108181

public class KnightProbabilityinChessboard {

	/*
	 * Naively the dp is a 3-dimensional array. But we only need the previous one to derive the current one, so I only preserve the previous one in the dp0 and calculate the current one in the dp1.

Let’s think about our formula, dp1[i][j] = sum(dp0[all reachable spots]). Assuming we are calculating the first step and all reachable spots are within the chessboard. Then the dp should be 8, which implies the initializing value should be 1.
	 */
	//better approach with bottom converting dp from 3d in top down to 2d in bottom up
	class BottomUp{
		int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
		public double knightProbability(int N, int K, int r, int c) {
		    int len = N;
		    double dp0[][] = new double[len][len];
		    for(double[] row : dp0) Arrays.fill(row, 1);
		    for(int l = 0; l < K; l++) {
		        double[][] dp1 = new double[len][len];
		        for(int i = 0; i < len; i++) {
		            for(int j = 0; j < len; j++) {
		                for(int[] move : moves) {
		                    int row = i + move[0];
		                    int col = j + move[1];
		                    if(isLegal(row, col, len)) dp1[i][j] += dp0[row][col];
		                }
		            }
		        }
		        dp0 = dp1;
		    }
		    return dp0[r][c] / Math.pow(8, K); 
		}
		private boolean isLegal(int r, int c, int len) {
		    return r >= 0 && r < len && c >= 0 && c < len;
		}
		
		
	}
	
	
	
	
	
	
	class TopDown {

		public double knightProbability(int N, int K, int r, int c) {
			double[][][] dp = new double[N][N][K + 1];

			int[] row = { -1, -2, -2, -1, 1, 2, 2, 1 };
			int[] col = { -2, -1, 1, 2, 2, 1, -1, -2 };

			return recurHelper(N, K, r, c, 0, dp, row, col);

		}

		double recurHelper(int N, int K, int r, int c, int moves, double dp[][][], int[] row, int[] col) {

			if (moves == K) {
				return 1;
			}
			if (dp[r][c][moves] != 0d) {
				return dp[r][c][moves];
			}
			double sum = 0;
			for (int i = 0; i < row.length; i++) {
				if (r + row[i] < N && c + col[i] < N && r + row[i] >= 0 && c + col[i] >= 0) {

					sum = sum + (1 / 8.0) * recurHelper(N, K, r + row[i], c + col[i], moves + 1, dp, row, col);
					}
			}

			dp[r][c][moves] = sum;

			return sum;
		}

	}
	

	

}
