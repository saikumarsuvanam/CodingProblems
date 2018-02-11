package Medium;

//https://leetcode.com/problems/ones-and-zeroes/discuss/95807
//474. Ones and Zeroes
import java.util.Arrays;

/*
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.

Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.

Note:
The given numbers of 0s and 1s will both not exceed 100
The size of given string array won't exceed 600.
Example 1:
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
Example 2:
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesandZeroes {

	class BottomUp {
		// Approach 1
		/*
		 * check approach 2 for better solution This problem is a typical 0-1
		 * knapsack problem, we need to pick several strings in provided strings
		 * to get the maximum number of strings using limited number 0 and 1. We
		 * can create a three dimensional array, in which dp[i][j][k] means the
		 * maximum number of strings we can get from the first i argument strs
		 * using limited j number of '0’s and k number of '1’s.
		 * 
		 * For dp[i][j][k], we can get it by fetching the current string i or
		 * discarding the current string, which would result in dp[i][j][k] =
		 * dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] and dp[i][j][k] =
		 * dp[i-1][j][k]; We only need to treat the larger one in it as the
		 * largest number for dp[i][j][k].
		 */
		public int findMaxForm(String[] strs, int m, int n) {
			int l = strs.length;
			int[][][] dp = new int[l + 1][m + 1][n + 1];

			for (int i = 0; i < l + 1; i++) {
				int[] nums = new int[] { 0, 0 };
				if (i > 0) {
					// calculate number of ones and zeros in a given String
					nums = calculate(strs[i - 1]);
				}
				for (int j = 0; j < m + 1; j++) {
					for (int k = 0; k < n + 1; k++) {
						if (i == 0) {
							dp[i][j][k] = 0;
						} else if (j >= nums[0] && k >= nums[1]) {
							dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
						} else {
							dp[i][j][k] = dp[i - 1][j][k];
						}
					}
				}
			}

			return dp[l][m][n];
		}

		// Approach 2
		/*
		 * reducing space complexity 3d to 2d
		 * 
		 */
		public int findMaxForm1(String[] strs, int m, int n) {
			int l = strs.length;
			int[][] dp = new int[m + 1][n + 1];

			for (int i = 0; i < m + 1; i++) {
				Arrays.fill(dp[i], 0);
			}

			int[] nums = new int[] { 0, 0 };
			for (String str : strs) {
				nums = calculate(str);
				// traverse from backwards
				for (int j = m; j >= nums[0]; j--) {
					for (int k = n; k >= nums[1]; k--) {
						if (j >= nums[0] && k >= nums[1]) {
							dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
						} else {
							dp[j][k] = dp[j][k];
						}
					}
				}
			}

			return dp[m][n];
		}

	}

	// not correct solution 58 test cases passed out of 63
	class TopDown {
		public int findMaxForm(String[] strs, int m, int n) {

			int[][][] dp = new int[strs.length][m + 1][n + 1];

			int[][] zeros = new int[strs.length][2];
			for (int i = 0; i < strs.length; i++) {
				zeros[i] = calculate(strs[i]);
			}

			return helper(strs, m, n, 0, dp, zeros);
		}

		int helper(String[] strs, int m, int n, int index, int[][][] dp, int[][] zeros) {
			if (index >= strs.length)
				return 0;
			if (dp[index][m][n] != 0) {

				if (dp[index][m][n] == -1) {
					return 0;
				}
				return dp[index][m][n];

			}
			int max = 0;
			for (int i = index; i < strs.length; i++) {
				int[] nums = zeros[i];
				if (m - nums[0] >= 0 && n - nums[1] >= 0) {
					int res = 1 + helper(strs, m - nums[0], n - nums[1], i + 1, dp, zeros);
					max = Math.max(max, res);
				}
			}
			if (max == 0) {
				dp[index][m][n] = -1;
			} else
				dp[index][m][n] = max;
			return max;
		}

	}

	// calculates number of zeros and 1s in a string
	private int[] calculate(String str) {
		int[] res = new int[2];
		Arrays.fill(res, 0);

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] s = new String[] { "10", "0001", "111001", "1", "0" };

		int m = 5, n = 3;

		OnesandZeroes o = new OnesandZeroes();
		BottomUp bt = o.new BottomUp();
		System.out.println(bt.findMaxForm1(s, m, n));

		TopDown tp = o.new TopDown();
		System.out.println(tp.findMaxForm(s, m, n));

	}

}
