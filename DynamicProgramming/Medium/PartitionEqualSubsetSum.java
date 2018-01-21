package Medium;

//416. Partition Equal Subset Sum https://leetcode.com/problems/partition-equal-subset-sum/discuss/
import java.util.Arrays;

public class PartitionEqualSubsetSum {

	class BottomUp {
		/*
		 * his problem is essentially let us to find whether there are several
		 * numbers in a set which are able to sum to a specific value (in this
		 * problem, the value is sum/2).
		 * 
		 * Actually, this is a 0/1 knapsack problem, for each number, we can
		 * pick it or not. Let us assume dp[i][j] means whether the specific sum
		 * j can be gotten from the first i numbers. If we can pick such a
		 * series of numbers from 0-i whose sum is j, dp[i][j] is true,
		 * otherwise it is false.
		 * 
		 * Base case: dp[0][0] is true; (zero number consists of sum 0 is true)
		 * 
		 * Transition function: For each number, if we don’t pick it, dp[i][j] =
		 * dp[i-1][j], which means if the first i-1 elements has made it to j,
		 * dp[i][j] would also make it to j (we can just ignore nums[i]). If we
		 * pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j
		 * is composed of the current value nums[i] and the remaining composed
		 * of other previous numbers. Thus, the transition function is dp[i][j]
		 * = dp[i-1][j] || dp[i-1][j-nums[i]]
		 */
		// with two dimensions dp matrix time-o(mn) and o(mn), m is the
		// partition sum and n is the length of nums
		public boolean canPartition(int[] nums) {
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if ((sum & 1) == 1) {
				return false;
			}
			sum /= 2;
			int n = nums.length;
			boolean[][] dp = new boolean[n][sum + 1];
			dp[0][0] = true;
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j <= sum; j++) {
					if (j == 0) {
						dp[i][j] = true;
					} else if (j - nums[i] >= 0 && i > 0) {
						dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
					}
				}
			}

			return dp[n - 1][sum];
		}

		// with one dimension go from backwards for loop sum i.e the trick to reduce it to one dimension
		public boolean canPartition1(int[] nums) {
			int sum = 0;

			for (int num : nums) {
				sum += num;
			}

			if ((sum & 1) == 1) {
				return false;
			}
			sum /= 2;

			int n = nums.length;
			boolean[] dp = new boolean[sum + 1];
			Arrays.fill(dp, false);
			dp[0] = true;

			for (int num : nums) {
				// trick is here traverse from backwards sum
				for (int i = sum; i > 0; i--) {
					if (i >= num) {
						dp[i] = dp[i] || dp[i - num];
					}
				}
			}

			return dp[sum];
		}
	}

	class TopDown {
		public boolean canPartition(int[] nums) {
			int sum = 0;
			for (int num : nums) {
				sum += num;
			}
			if ((sum & 1) == 1) {
				return false;
			}
			sum /= 2;
			int n = nums.length;
			int[] dp = new int[sum + 1];
			return helper(0, sum, nums, dp);

		}

		boolean helper(int index, int sum, int[] nums, int[] dp) {
			if (sum < 0) {
				return false;
			}
			if (sum == 0) {
				return true;
			}
			if (dp[sum] != 0) {
				if (dp[sum] == 1)
					return true;
				else
					return false;
			}
			for (int i = index; i < nums.length; i++) {
				boolean ans = helper(i + 1, sum - nums[i], nums, dp);
				if (ans) {
					dp[sum] = 1;
					return true;
				}
			}
			dp[sum] = -1;
			return false;

		}
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		BottomUp bt = p.new BottomUp();
		int[] nums = new int[] { 2, 5, 3 };
		System.out.println(bt.canPartition(nums));

	}

}
