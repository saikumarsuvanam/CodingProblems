package Medium;

import java.util.Arrays;

//300. Longest Increasing Subsequence
/*
 *  Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? 
 */
public class LongestIncreasingSubSequence {

	/*
	 * Let S[pos] be defined as the smallest integer that ends an increasing
	 * sequence of length pos. Now iterate through every integer X of the input
	 * set and do the following:
	 * 
	 * If X > last element in S, then append X to the end of S. This essentialy
	 * means we have found a new largest LIS.
	 * 
	 * Otherwise find the smallest element in S, which is >= than X, and change
	 * it to X. Because S is sorted at any time, the element can be found using
	 * binary search in log(N).
	 * 
	 * Total runtime - N integers and a binary search for each of them - N *
	 * log(N) = O(N log N)
	 * 
	 * Now let's do a real example:
	 * 
	 * Collection of integers: 2 6 3 4 1 2 9 5 8
	 * 
	 * Steps:
	 * //https://stackoverflow.com/questions/2631726/how-to-determine-the-
	 * longest-increasing-subsequence-using-dynamic-programming 0. S = {} -
	 * Initialize S to the empty set 1. S = {2} - New largest LIS 2. S = {2, 6}
	 * - New largest LIS 3. S = {2, 3} - Changed 6 to 3 4. S = {2, 3, 4} - New
	 * largest LIS 5. S = {1, 3, 4} - Changed 2 to 1 6. S = {1, 2, 4} - Changed
	 * 3 to 2 7. S = {1, 2, 4, 9} - New largest LIS 8. S = {1, 2, 4, 5} -
	 * Changed 9 to 5 9. S = {1, 2, 4, 5, 8} - New largest LIS
	 * 
	 * So the length of the LIS is 5 (the size of S).
	 * 
	 * To reconstruct the actual LIS we will again use a parent array. Let
	 * parent[i] be the predecessor of element with index i in the LIS ending at
	 * element with index i.
	 */
	static class NlogNSolution {
		public static int lengthOfLIS(int[] nums) {
			int dp[] = new int[nums.length];
			int len = 0;
			for (int i = 0; i < nums.length; i++) {
				int index = Arrays.binarySearch(dp, 0, len, nums[i]);
				index = -(index + 1);
				dp[index] = nums[i];
				len = len <= index ? index + 1 : len;
			}
			return len;

		}
	}

	static class BottomUP {
		public static int lengthOfLIS(int[] nums) {
			if (nums.length == 0)
				return 0;
			int maxlengthSequence = 0;
			int[] dp = new int[nums.length];
			int n = nums.length;
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j <= i; j++) {
					if (nums[i] > nums[j]) {
						// including nums[i] in the longest increasing sequence
						dp[i] = Math.max(dp[i], 1 + dp[j]);
					}
				}
				// overall including nums[i] and excluding nums[i] save the max
				// in maxlengthsequence global
				maxlengthSequence = Math.max(maxlengthSequence, dp[i]);

			}

			/*
			 * we can update the below code in the above for loops itself
			 * 
			 * for (int i = 0; i < n; i++) { maxlengthSequence =
			 * Math.max(maxlengthSequence, dp[i]); }
			 */
			return maxlengthSequence;

		}

	}

	static class TopDown {
		public static int lengthOfLIS(int[] nums) {
			return recurLIS(nums, nums.length - 1);
		}

		static int max = 0;

		static int recurLIS(int[] nums, int n) {
			if (n == 0)
				return 1;
			int length = 1;
			int maxlength = 0;
			for (int i = 0; i < n; i++) {
				int res = recurLIS(nums, i);
				if (nums[n] > nums[i]) {
					length = 1 + res;
				}
				maxlength = Math.max(maxlength, length);
			}
			max = Math.max(max, maxlength);
			return maxlength;

		}

	}

	public static void main(String[] args) {
		LongestIncreasingSubSequence l = new LongestIncreasingSubSequence();
		int[] nums = new int[] { 2, 6, 3, 4, 1, 2, 9, 5, 8 };
		TopDown.lengthOfLIS(nums);// call method
		System.out.println(TopDown.max);// TopDownResult
		// BottomUp Result
		System.out.println(BottomUP.lengthOfLIS(nums));

		System.out.println(NlogNSolution.lengthOfLIS(nums));

	}
}
