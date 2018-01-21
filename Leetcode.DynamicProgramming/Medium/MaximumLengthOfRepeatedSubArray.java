package Medium;
//718. Maximum Length of Repeated Subarray //https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

/*
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfRepeatedSubArray {
	
	//Approach 1:Dp Solution not better with space and time
	// in order to avoid one dimension for space, used prev and temp to store dp[i][j]
	//for calculating used this :dp[i+1][j+1]=1+dp[i][j]
	
	public int findLength(int[] A, int[] B) {
		int max = 0;
		int dp[] = new int[B.length + 1];
		int prev = 0;
		for (int i = 0; i < A.length; i++) {
			prev = 0;
			for (int j = 0; j < B.length; j++) {
				int temp = dp[j + 1];
				if (A[i] == B[j]) {
					dp[j + 1] = 1 + prev;
				} else {
					dp[j + 1] = 0;
				}
				prev = temp;
				max = Math.max(max, dp[j + 1]);
			}
		}
		
		return max;

	}
	
	
	
	
	
	
	
	
	
	
	//Approach2: Goodone with better time and space

	/*
	 * 1) choose a length of substring by binary search( low, high, mid) 
	 * 2) Compute rolling hash values for both strings for a given length mid 
	 * 3) match the two rolling hashes and see if they are the same and reposition
	 *    the binary search accordingly.
	 *    
	 *    Time Complexity: O((M+N)∗log(min(M,N))), where M, NM,N are the lengths of A, B. The log factor is contributed by the binary search, while creating the rolling hashes is O(M + N)O(M+N). The checks for duplicate hashes are O(1)O(1). If we perform a naive check to make sure our answer is correct, it adds a factor of O(\min(M, N))O(min(M,N)) to our cost of check, which keeps the complexity the same.

         Space Complexity: O(M)O(M), the space used to store hashes and the subarrays in our final naive check.
	 *    
	 *    
	 *    
	 */
	class Solution {
		int P = 113;
		int MOD = 1_000_000_007;
		int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

		private int[] rolling(int[] source, int length) {
			int[] ans = new int[source.length - length + 1];
			long h = 0, power = 1;
			if (length == 0)
				return ans;
			for (int i = 0; i < source.length; ++i) {
				h = (h + source[i] * power) % MOD;
				if (i < length - 1) {
					power = (power * P) % MOD;
				} else {
					ans[i - (length - 1)] = (int) h;
					h = (h - source[i - (length - 1)]) * Pinv % MOD;
					if (h < 0)
						h += MOD;
				}
			}
			return ans;
		}

		private boolean check(int guess, int[] A, int[] B) {
			Map<Integer, List<Integer>> hashes = new HashMap();
			int k = 0;
			for (int x : rolling(A, guess)) {
				hashes.computeIfAbsent(x, z -> new ArrayList()).add(k++);
			}
			int j = 0;
			for (int x : rolling(B, guess)) {
				for (int i : hashes.getOrDefault(x, new ArrayList<Integer>()))
					if (Arrays.equals(Arrays.copyOfRange(A, i, i + guess), Arrays.copyOfRange(B, j, j + guess))) {
						return true;
					}
				j++;
			}
			return false;
		}

		public int findLength(int[] A, int[] B) {
			int lo = 0, hi = Math.min(A.length, B.length) + 1;
			while (lo < hi) {
				int mi = (lo + hi) / 2;
				if (check(mi, A, B))
					lo = mi + 1;
				else
					hi = mi;
			}
			return lo - 1;
		}
	}
}
