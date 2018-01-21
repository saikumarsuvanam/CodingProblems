package Medium;
//413. Arithmetic Slices //https://leetcode.com/problems/arithmetic-slices/solution/

/*
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


 */
public class ArithmeticSlices {

	public class Solution {
	    
	    
	    //using math formula
		/*
		 *  we can just keep a track of the number of consecutive elements satisfying the common differnce criteria in a countcount variable and just update the sumsum directly as count*(count+1)/2count∗(count+1)/2 whenver an element not satisfying this criteria is found. At the same time, we also need to reset the countcount value.
		 */
	    public int numberOfArithmeticSlices(int[] A) {
	        int count = 0;
	        int sum = 0;
	        for (int i = 2; i < A.length; i++) {
	            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
	                count++;
	            } else {
	                sum += (count + 1) * (count) / 2;
	                count = 0;
	            }
	        }
	        return sum += count * (count + 1) / 2;
	    }
	    
	    
	   // using constant space dynamic programming
	    /*
	     * we can start filling the dpdp in a forward manner. The intuition remains the same as in the last approach. For the i^{th}i
​th
​​  element being considered, we check if this element satsfies the common difference criteria with the previous element. If so, we know the number of new arithmetic slices added will be 1+dp[i-1]1+dp[i−1] as discussed in the last approach. The sumsum is also updated by the same count to reflect the new arithmetic slices added.
	     */
	       public int BottomupnumberOfArithmeticSlices(int[] A) {
	         int dp = 0;
	         int sum = 0;
	         for (int i = 2; i < A.length; i++) {
	             if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
	                 dp = 1 + dp;
	                 sum += dp;
	             } else
	                 dp = 0;
	         }
	         return sum;
	     }
	}

}
