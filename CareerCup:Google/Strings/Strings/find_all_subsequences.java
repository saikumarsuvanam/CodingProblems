package Strings;
//http://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/

//https://www.careercup.com/question?id=5757597581836288
/*Question: Given two strings, find number of discontinuous matches.
Example: “cat”, “catapult”
Output: 3   => “CATapult”, “CatApulT”, “CAtapulT”
*/
public class find_all_subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "catapult";
		String s2 = "cat";
		if (s1.length() > s2.length()) {

			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		// pass small and larger strings
		System.out.println(find_no_of_subsequences(s1, s2, s1.length() - 1, s2.length() - 1, ""));

	}

	// s1 is cat
	// s2 is catapult
	static int find_no_of_subsequences(String s1, String s2, int m, int n, String Result) {
		int count = 0;
		if (m == -1 && n == -1 || m == -1) {
			System.out.println(Result);
			return 1;
		} else if (n == -1) {
			return 0;

		}

		else {
			if (s1.charAt(m) == s2.charAt(n)) {
				String Result1 = s2.toUpperCase().charAt(n) + Result;
				String Result2 = s2.charAt(n) + Result;

				count += find_no_of_subsequences(s1, s2, m - 1, n - 1, Result1)
						+ find_no_of_subsequences(s1, s2, m, n - 1, Result2);
			} else {
				Result = s2.charAt(n) + Result;
				count += find_no_of_subsequences(s1, s2, m, n - 1, Result);
			}
		}
		return count;
	}
}