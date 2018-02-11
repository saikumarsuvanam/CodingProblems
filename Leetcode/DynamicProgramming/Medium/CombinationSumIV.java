package Medium;

//377. Combination Sum IV https://leetcode.com/problems/combination-sum-iv/description/
/*
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */
public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i <= target; i++) {

			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					dp[i] = dp[i] + dp[i - nums[j]];
				}
			}
		}
		return dp[target];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
