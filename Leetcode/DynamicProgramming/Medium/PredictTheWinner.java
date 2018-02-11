package Medium;

public class PredictTheWinner {
	public boolean PredictTheWinner(int[] nums) {

		return helper(nums, 0, nums.length - 1, 0, 0, true);

	}

	boolean helper(int[] nums, int start, int end, int sum1, int sum2, boolean who) {
		if (start > end) {
			if (sum1 >= sum2) {
				return true;
			} else
				return false;

		}
		if (who) {
			boolean res1 = helper(nums, start + 1, end, sum1 + nums[start], sum2, !who);
			boolean res2 = helper(nums, start, end - 1, sum1 + nums[end], sum2, !who);
			return res1 || res2;
		} else {
			boolean res1 = helper(nums, start + 1, end, sum1, sum2 + nums[start], !who);
			boolean res2 = helper(nums, start, end - 1, sum1, sum2 + nums[end], !who);
			return res1 || res2;

		}

	}

	public static void main(String[] args) {

	}
}
