package Easy;

/*problem 53:https://leetcode.com/problems/maximum-subarray/description/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

public class maximumSubarray {
	
	
	

	public int maxSubArray(int[] nums) {
		Integer maxSum = null;
		Integer currSum = null;
		for (int num : nums) {
			if (currSum == null || maxSum == null) {
				currSum = num;
				maxSum = num;
				continue;
			}
			currSum = Math.max(currSum + num, num);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;

	}
	
	
	/*LeetCode 
	  class Solution {
  public int maxSubArray(int[] nums) {
      int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length; i++) {
          maxEndingHere += nums[i];
          if (maxEndingHere > maxSoFar) maxSoFar = maxEndingHere;
          if (maxEndingHere < 0) maxEndingHere = 0;
      }
      return maxSoFar;
  }
}
	 */
}
