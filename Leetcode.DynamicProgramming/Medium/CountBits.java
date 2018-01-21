package Medium;

/*//338. Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2]. 
 */
public class CountBits {

	// hint clean and neat :An easy recurrence for this problem is 
	//f[i] = f[i /2] + i % 2.
	// Approach 1
	public int[] countBits(int num) {
		int[] f = new int[num + 1];
		for (int i = 1; i <= num; i++)
			f[i] = f[i >> 1] + (i & 1);
		return f;
	}

	// Approach 2
	public int[] countBitsSlow(int num) {
		int count = 0;
		int dp[] = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			if (i == (int) Math.pow(2, count)) {
				dp[i] = 1;
				count++;
			} else if (Math.pow(2, count) > i) {
				dp[i] = dp[(int) Math.pow(2, count - 1)] + dp[i - (int) Math.pow(2, count - 1)];
			}

			// else {
			// dp[i] = dp[(int) Math.pow(2, count)] + dp[i - (int) Math.pow(2,
			// count)];
			//
			// }
		}
		return dp;
	}

	public static void main(String[] args) {
		CountBits c = new CountBits();
		int[] res = c.countBits(100);
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i]);

	}
}
