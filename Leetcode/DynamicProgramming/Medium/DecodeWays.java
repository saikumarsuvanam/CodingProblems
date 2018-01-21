package DynamicProgramming.Medium;

//91. Decode Ways  https://leetcode.com/problems/decode-ways/description/
/* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2
 * 
 */
//91. Decode Ways https://leetcode.com/problems/decode-ways/description/
public class DecodeWays {
	// Approach 1 leetcode o(1) space and o(n) time
	int numDecodings1(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		// r2: decode ways of s[i-2] , r1: decode ways of s[i-1]
		int r1 = 1, r2 = 1;
		char schar[] = s.toCharArray();
		for (int i = 1; i < schar.length; i++) {
			// zero voids ways of the last because zero cannot be used
			// separately
			if (schar[i] == '0')
				r1 = 0;

			// possible two-digit letter, so new r1 is sum of both while new r2
			// is the old r1
			if (schar[i - 1] == '1' || schar[i - 1] == '2' && schar[i] <= '6') {

				r1 = r2 + r1;
				r2 = r1 - r2;
			}

			// one-digit letter, no new way added
			else {
				r2 = r1;
			}
		}

		return r1;
	}

	// Approach 2 o(n) space and o(n) time
	public static int numDecodings(String s) {

		int dp[] = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			if ('1' <= s.charAt(i) && s.charAt(i) <= '9') {
				if (i == 0) {
					dp[i + 1] = 1;
					continue;
				} else {
					dp[i + 1] = dp[i];
				}
				if (i == 1 && 10 <= Integer.parseInt(s.substring(i - 1, i + 1))
						&& Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
					dp[i + 1] = 2;
				} else if (10 <= Integer.parseInt(s.substring(i - 1, i + 1))
						&& Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
					dp[i + 1] = dp[i] + dp[i - 1];
				}
			}

			else if (i == 1 && 10 <= Integer.parseInt(s.substring(i - 1, i + 1))
					&& Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
				dp[i + 1] = 1;
			} else if (i != 0 && 10 <= Integer.parseInt(s.substring(i - 1, i + 1))
					&& Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {

				dp[i + 1] = dp[i - 1];
			} else {
				dp[i + 1] = 0;
			}

		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("10"));
	}
}
