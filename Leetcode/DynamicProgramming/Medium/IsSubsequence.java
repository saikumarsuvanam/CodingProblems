package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//392. Is Subsequence https://leetcode.com/problems/is-subsequence/description/

/*
 * Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {

	// For follow up i.e. for many Strings
	// Record the indexes for each character in t, if s[i] matches t[j], then
	// s[i+1] should match a character in t with index bigger than j. This can
	// be reduced to find the first element larger than a value in an sorted
	// array (find upper bound), which can be achieved using binary search.
	// PreProcess:
	// First Store each character in t in a map wth key as map and values as
	// indices of key appearing
	// at different positions in t
	// Query:
	// for every character in String s, get the values from the key and do the
	// binary search to get
	// the value

	// Follow-up: O(N) time for pre-processing, O(MlogN) for each S.where n is
	// the length of T and M is the length of S
	// Eg-1. s="abc", t="bahbgdca"
	// idx=[a={1,7}, b={0,3}, c={6}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=3
	// i=2 ('c'): prev=6 (return true)
	// Eg-2. s="abc", t="bahgdcb"
	// idx=[a={1}, b={0,6}, c={5}]
	// i=0 ('a'): prev=1
	// i=1 ('b'): prev=6
	// i=2 ('c'): prev=? (return false)

	//
	// Follow up Question

	class MultipleQueries {

		List<Integer>[] idx = new List[256]; // Just for clarity

		public void preprocess(String t) {
			for (int i = 0; i < t.length(); i++) {
				if (idx[t.charAt(i)] == null)
					idx[t.charAt(i)] = new ArrayList<>();
				idx[t.charAt(i)].add(i);
			}

		}

		public boolean isSubsequence(String s, String t) {
			// prev is previous matched index in t with the character in s
			int prev = -1;
			for (int i = 0; i < s.length(); i++) {
				if (idx[s.charAt(i)] == null)
					return false;
				List li = idx[s.charAt(i)];
				prev = BinarySearch(0, li.size() - 1, prev, li);
				if (prev == -1) {
					return false;
				}

			}
			return true;
		}

		int BinarySearch(int low, int high, int prev, List<Integer> li) {
			while (low < high) {
				int mid = (low + high) / 2;
				if (prev < li.get(mid)) {
					high = mid;
				} else if (prev >= li.get(mid)) {
					low = mid + 1;
				}
			}
			if (li.get(low) > prev) {
				return li.get(low);
			}
			return -1;
		}
	}

	class SingleQuery {
		// For only one String
		public boolean isSubsequence(String s, String t) {
			if (s.length() == 0)
				return true;
			int j = 0;
			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == s.charAt(j)) {
					j++;
				}
				if (j == s.length()) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		IsSubsequence is = new IsSubsequence();
		// String s = "abc", t = "ahbgdc";
		String s = "bahccc", t = "bahbgdcabccb";

		SingleQuery s1 = is.new SingleQuery();
		System.out.println(s1.isSubsequence(s, t));

		MultipleQueries m = is.new MultipleQueries();
		String ms[] = new String[] { "abc", "abcbcc", s };
		m.preprocess(t);
		for (int i = 0; i < ms.length; i++)
			System.out.println(m.isSubsequence(ms[i], t));
	}
}
