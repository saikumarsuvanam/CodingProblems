package Strings;

//http://www.geeksforgeeks.org/longest-common-substring/
/*Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = "GeeksforGeeks", y = "GeeksQuiz"
Output : 5
The longest common substring is "Geeks" and is of
length 5.

Input : X = "abcdxyz", y = "xyzabcd"
Output : 4
The longest common substring is "abcd" and is of
length 4.

Input : X = "zxabcdezy", y = "yzabcdezx"
Output : 6
The longest common substring is "abcdez" and is of
length 6.
The longest common suffix has following optimal substructure property
   LCSuff(X, Y, m, n) = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1]
                        0  Otherwise (if X[m-1] != Y[n-1])

The maximum length Longest Common Suffix is the longest common substring.
   LCSubStr(X, Y, m, n)  = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m
                                                     and 1 <= j <= n
*/
public class find_largest_common_substring_between_two_strings {

	public static void main(String[] args) {
		String s1 = "geeksforgeeks";
		String s2 = "geek";
		lcs(s1, s2);
	}

	// bootom up approach
	static void lcs(String s1, String s2) {
		int[][] table = new int[s1.length() + 1][s2.length() + 1];
		int largest = Integer.MIN_VALUE;
		int largestendindex = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					table[i][j] = table[i - 1][j - 1] + 1;

				} else
					table[i][j] = 0;
				if (largest < table[i][j]) {
					largest = table[i][j];
					largestendindex = i;
				}
			}
		}
		System.out.println(s1.substring(largestendindex - largest, largestendindex));
	}

}
