package Hard;

import java.util.HashMap;

//410. Split Array Largest Sum
//https://leetcode.com/problems/split-array-largest-sum/solution/
/* Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
Note:
If n is the length of array, assume the following constraints are satisfied:

    1 ≤ n ≤ 1000
    1 ≤ m ≤ min(50, n)
    
    Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/
public class SplitArrayLargestSum {

	class BinarySearch {
		// Approach 1
		/*
		 * 
		 * Time complexity : O(n∗log(sum of array))O(n * log(sum \ of \
		 * array))O(n∗log(sum of array)). The binary search costs O(log(sum of
		 * array))O(log(sum \ of \ array))O(log(sum of array)), where sum of
		 * array is the sum of elements in nums. For each computation of F(x),
		 * the time complexity is O(n)O(n)O(n) since we only need to go through
		 * the whole array.
		 * 
		 * Space complexity : O(n)O(n)O(n). Same as the Brute Force approach. We
		 * only need the space to store the array.
		 * 
		 * The problem can be solved by using binary search, which is a quite
		 * brilliant way. If m equals length of the array, the largest sum
		 * should be the maximum among the elements. If m equals 1, then it
		 * should be the sum of all elements in the array. Now the maximum sum
		 * of a subarray should be between these two numbers.
		 * 
		 * The idea is to using binary search and find this minimum maximum sum.
		 * We set left to the maximum element of the array and right to the sum
		 * of the array. First we choose the mid of these two and find if there
		 * exist m subarrays that have largest sum less than or equal to mid. If
		 * we can find such split, we know we probably can do better. So we set
		 * right to mid. We keep on doing this until we find a value that we
		 * cannot get by splitting the array to m subarrays, i.e., the number is
		 * too small that we need to split the array further more. Now we
		 * increase left to mid + 1. When left = right, we find the number.
		 */
		public int splitArray(int[] nums, int m) {
			if (nums.length == 0) {
				return 0;
			}
			int left = 0, right = 0;
			for (int n : nums) {
				left = Math.max(left, n);
				right += n;
			}
			if (m == nums.length) {
				return left;
			}
			if (m == 1) {
				return right;
			}
			while (left < right) {
				int mid = (left + right) / 2;
				if (canSplit(nums, mid, m)) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			return left;
		}

		private boolean canSplit(int[] nums, int maxVal, int m) {
			int countSub = 1;
			int currSum = 0;
			for (int n : nums) {
				currSum += n;
				if (currSum > maxVal) {
					currSum = n;
					countSub++;
					if (countSub > m) {
						return false;
					}
				}
			}
			return true;
		}
	}

	// Apprpach 2:
	class recursiveDFS {
		/*
		 * 
		 * Time complexity : O(n^m). To split n elements into m parts, we can
		 * have {n - 1}c{m - 1} different solutions. This is equivalent to n ^
		 * m​​.
		 * 
		 * Space complexity : O(n). We only need the space to store the array.
		 * 
		 * We can use depth-first search to generate all possible splitting
		 * plan. For each element in the array, we can choose to append it to
		 * the previous subarray or start a new subarray starting with that
		 * element (if the number of subarrays does not exceed m). The sum of
		 * the current subarray can be updated at the same time.
		 */
		private int ans;
		private int n, m;
		HashMap<String, Integer> h = new HashMap<String, Integer>();

		private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
			if (i == n && cntSubarrays == m) {
				ans = Math.min(ans, curMax);
				return;
			}
			if (i == n) {

				return;
			}

			int res = 0;
			if (i > 0) {
				dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
			}
			if (cntSubarrays < m) {
				dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
			}

		}

		public int splitArray(int[] nums, int M) {
			ans = Integer.MAX_VALUE;
			n = nums.length;
			m = M;
			dfs(nums, 0, 0, 0, 0);
			return ans;
		}
	}

	// Approach 3 Bootom Up
	class BottomUp {
		/*
		 * Let's define f[i][j] to be the minimum largest subarray sum for
		 * splitting nums[0..i] into j parts.
		 * 
		 * Consider the jth subarray. We can split the array from a smaller
		 * index k to i to form it. Thus f[i][j] can be derived from max(f[k][j
		 * - 1], nums[k + 1] + ... + nums[i]). For all valid index k, f[i][j]
		 * should choose the minimum value of the above formula.
		 * 
		 * The final answer should be f[n][m], where n is the size of the array.
		 * 
		 * For corner situations, all the invalid f[i][j] should be assigned
		 * with INFINITY, and f[0][0] should be initialized with 0.
		 * 
		 * 
		 * Time complexity : O(n2∗m) The total number of states is O(n∗m)O(n *
		 * m)O(n∗m). To compute each state f[i][j], we need to go through the
		 * whole array to find the optimum k. This requires another O(n) loop.
		 * So the total time complexity is O(n2∗m)O
		 * 
		 * Space complexity : O(n∗m). The space complexity is equivalent to the
		 * number of states, which is O(n∗m)
		 */
		public int splitArray(int[] nums, int m) {
			int n = nums.length;
			int[][] f = new int[n + 1][m + 1];
			int[] sub = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					f[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < n; i++) {
				sub[i + 1] = sub[i] + nums[i];
			}
			f[0][0] = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					for (int k = 0; k < i; k++) {
						f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
					}
				}
			}
			return f[n][m];
		}
	}
}
