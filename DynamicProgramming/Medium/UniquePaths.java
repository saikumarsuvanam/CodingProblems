package Medium;

/*62. Unique Paths https://leetcode.com/problems/unique-paths/description/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/
public class UniquePaths {

	//Approach 1: space o(mn), time o(mn) can be solved with math in o(1) space and o(m) or o(n) space 
	//With Dp 
	public int uniquePaths(int m, int n) {

		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			}

		}

		return dp[m - 1][n - 1];

	}
	
	/*This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

	For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as ‘D’ and right as ‘R’, following is one of the path :-

	D R R R D R R R

	We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-
*/
	//Total permutations = (m+n)! / (m! * n!)
	//space is o(1) and time is Math.max(m,n)
	public class Solution {
	    public int uniquePaths(int m, int n) {
	        if(m == 1 || n == 1)
	            return 1;
	        m--;
	        n--;
	        if(m < n) {              // Swap, so that m is the bigger number
	            m = m + n;
	            n = m - n;
	            m = m - n;
	        }
	        long res = 1;
	        int j = 1;
	        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
	            res *= i;
	            res /= j;
	        }
	            
	        return (int)res;
	    }
	}
}
