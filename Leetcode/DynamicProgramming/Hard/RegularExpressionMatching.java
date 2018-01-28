package DynamicProgramming.Hard;

/*10. Regular Expression Matching 
 /https://leetcode.com/problems/regular-expression-matching/description/
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {

		boolean dp[][] = new boolean[p.length() + 1][s.length() + 1];

		dp[0][0] = true;
		for (int i = -1; i < p.length(); i++) {

			for (int j = -1; j < s.length(); j++) {
				if (j == -1) {
					dp[i + 1][j + 1] = true;
					dp[0][0] = true;
				} else if (i == -1) {
					dp[i + 1][j + 1] = false;
					dp[0][0] = true;
				} else if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(i) == '*') {
					dp[i + 1][j + 1] = dp[i][j + 1];
				} else {
					dp[i + 1][j + 1] = dp[i][j + 1];
				}

			}

		}
		return dp[p.length()][s.length()];
	}

	class TopDown {
		public boolean isMatch(String s, String p) {

			return helper(s, p, 0, 0);

		}

		boolean helper(String s, String p, int n, int m) {

			if (n >= s.length() && (m + 1 <= p.length() - 1 && (m >= p.length() - 2 && p.charAt(m + 1) == '*'))) {
				return true;
			} else if (n >= s.length() && m < p.length() - 1) {
				return false;
			} else if (p.length() < m) {
				return false;
			} else if (s.length() < n) {
				return false;
			}
			if (m < p.length() && n < s.length()) {
				if (m + 1 < p.length() && p.charAt(m + 1) == '*') {
					boolean res1 = false;
					if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '.') {
						res1 = helper(s, p, n + 1, m);
					}
					boolean res2 = helper(s, p, n, m + 2);
					return res1 || res2;
				} else if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '.') {
					return helper(s, p, n + 1, m + 1);
				} else {
					return false;
				}
			} else
				return false;

		}
	}

	public static void main(String[] args) {
		RegularExpressionMatching r = new RegularExpressionMatching();
		TopDown t = r.new TopDown();
		System.out.println(t.isMatch("aaa", "a.."));
	}
}
