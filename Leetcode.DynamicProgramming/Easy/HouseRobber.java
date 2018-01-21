package Easy;
//198. House Robber https://leetcode.com/problems/house-robber/description/

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class HouseRobber {

	// Main Approach1
	// without using Dp leetcode
	// Time-o(n) space o(1)
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int withPrev = nums[0];
		int withoutPrev = 0;
		int temp;
		for (int i = 1; i < nums.length; i++) {

			// find max value without considering nums[i] current value
			temp = Math.max(withoutPrev, withPrev);
			// consider the current nums[i] value without considering previous  value
			withPrev = withoutPrev + nums[i];
			withoutPrev = temp;

		}
		// finally find max of with previous and without previous
		return Math.max(withPrev, withoutPrev);

	}

	// Approach 2
	public int robDp(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int dp[] = new int[nums.length];
		dp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (i - 2 >= 0)
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			else {
				dp[i] = Math.max(nums[i], dp[i - 1]);
			}
		}
		return dp[nums.length - 1];
	}

}
