package Easy;

//303. Range Sum Query - Immutable https://leetcode.com/problems/range-sum-query-immutable/description/

////Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//Example:
//
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
//
//Note:
//
//    You may assume that the array does not change.
//    There are many calls to sumRange function.

public class RangeSumQuery {

	/**
	 * Your RangeSumQuery object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums); int param_1 = obj.sumRange(i,j);
	 */

	/*Logic
	 * Imagine that we pre-compute the cummulative sum from index 000 to kkk.
	 * Could we use this information to derive Sum(i,j)Sum(i, j)Sum(i,j)?
	 * 
	 * Let us define sum[k]sum[k]sum[k] as the cumulative sum for
	 * nums[0⋯k−1]nums[0 \cdots k-1]nums[0⋯k−1] (inclusive):
	 * 
	 * sum[k]={∑i=0k−1nums[i],k>00,k=0 sum[k] = \left\{ \begin{array}{rl}
	 * \sum_{i=0}^{k-1}nums[i] & , k > 0 \\ 0 &, k = 0 \end{array} \right.
	 * sum[k]=​⎩​⎪​⎨​⎪​⎧​​​​i=0​∑​k−1​​nums[i]​0​​​,k>0​,k=0​​
	 * 
	 * Now, we can calculate sumRange as following:
	 * 
	 * sumRange(i,j)=sum[j+1]−sum[i] sumRange(i, j) = sum[j + 1] - sum[i]
	 * sumRange(i,j)=sum[j+1]−sum[i]
	 */

	// space -o(n) time-o(1) per query
	private int[] sum;

	public RangeSumQuery(int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}
}
