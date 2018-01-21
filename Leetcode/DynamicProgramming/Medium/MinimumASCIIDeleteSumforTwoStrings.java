package DynamicProgramming.Medium;
//Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

//Example 1:
//Input: s1 = "sea", s2 = "eat"
//Output: 231
//Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
//Deleting "t" from "eat" adds 116 to the sum.
//At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

/*
 * Let dp[i][j] be the answer to the problem for the strings s1[i:], s2[j:].

When one of the input strings is empty, the answer is the ASCII-sum of the other string. We can calculate this cumulatively using code like dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i).

When s1[i] == s2[j], we have dp[i][j] = dp[i+1][j+1] as we can ignore these two characters.

When s1[i] != s2[j], we will have to delete at least one of them. We'll have dp[i][j] as the minimum of the answers after both deletion options.
 */
import java.util.Arrays;

// 712. Minimum ASCII Delete Sum for Two Strings
public class MinimumASCIIDeleteSumforTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int s1c = 0;// variable to store a character value in string 1
		int s2c = 0;// variable to store a character value in string 2
		for (int i = 0; i < s1.length(); i++) {
			s1c = (int) s1.charAt(i);
			dp[i + 1][0] = s1.charAt(i) + dp[i][0];// to fillup the first column
													// considering s2 is empty
			for (int j = 0; j < s2.length(); j++) {
				s2c = (int) s2.charAt(j);
				dp[0][j + 1] = s2.charAt(j) + dp[0][j];// to fill up the first
														// row considering s1 is
														// empty
				if (s1.charAt(i) != s2.charAt(j)) {

					dp[i + 1][j + 1] = Math.min(s1c + dp[i][j + 1], s2c + dp[i + 1][j]);

				} else {
					dp[i + 1][j + 1] = dp[i][j];
				}
			}
		}

		return dp[s1.length()][s2.length()];

	}

	public static void main(String[] args) {
		MinimumASCIIDeleteSumforTwoStrings mn = new MinimumASCIIDeleteSumforTwoStrings();
		System.out.println(mn.minimumDeleteSum("delete", "leet"));
	}
}
