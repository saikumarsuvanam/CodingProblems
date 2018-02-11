package Medium;
//Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

// 712. Minimum ASCII Delete Sum for Two Strings
public class MinimumASCIIDeleteSumforTwoStrings {
	public int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int s1c = 0;// variable to store a character value in string 1
		int s2c = 0;// variable to store a character value in string 2
		for (int i = 0; i < s1.length(); i++) {
			s1c = s1.charAt(i);
			dp[i + 1][0] = s1.charAt(i) + dp[i][0];// to fillup the first column
													// considering s2 is empty
			for (int j = 0; j < s2.length(); j++) {
				s2c = s2.charAt(j);
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
