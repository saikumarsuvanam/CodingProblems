package Strings;
//http://www.geeksforgeeks.org/longest-repeating-and-non-overlapping-substring/

//without dynammic programming this problem can be solved using suffix tree
public class longest_repeating_substring_without_overlapping {

	public static void main(String[] args) {
		longest_repeating_substring_without_overlapping t = new longest_repeating_substring_without_overlapping();
		String s = "aabaabaaba";
		lrs(s);
	}

	// Dynamic programming space-0(n*n) and time -0(n*n)
	static void lrs(String s) {
		int[][] table = new int[s.length() + 1][s.length() + 1];
		int largest = Integer.MIN_VALUE;
		int largestendindex = 0;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				// table[i-1][j-1]<j-i for non overlapping
				if (s.charAt(i - 1) == s.charAt(j - 1) && table[i - 1][j - 1] < j - i) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else
					table[i][j] = 0;
				if (largest < table[i][j]) {
					largest = table[i][j];
					largestendindex = j;
				}
			}
		}
		System.out.println(largest);
		System.out.println(s.substring(largestendindex - largest, largestendindex));

	}
}
