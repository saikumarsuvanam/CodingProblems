package Strings;
import java.util.HashMap;

//https://www.careercup.com/question?id=5389078581215232
/*Given two strings a and b, find whether any anagram of string a is a sub-string of string b. For eg:
if a = xyz and b = afdgzyxksldfm then the program should return true.
  
 */
public class find_any_anagram_of_word_is_a_sub_string_of_another {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abcdefg";

		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if (!hMap.containsKey(s1.charAt(i)))
				hMap.put(s1.charAt(i), 1);
			else {
				int cnt = (int) hMap.get(s1.charAt(i)) + 1;
				hMap.put(s1.charAt(i), cnt);
			}
		}

		int s1count = s1.length();
		System.out.println(find_matching(hMap, s2, s1count));// not good
		System.out.println(ContainsAnagramSlidingWindow(s1, s2));// good
																	// solution

	}

	// clone() method and resetting takes more time in this method-check 2nd
	// method for good solution
	static boolean find_matching(HashMap<Character, Integer> h, String s2, int s1count) {
		int count = s1count;
		HashMap<Character, Integer> h1 = (HashMap<Character, Integer>) h.clone();
		for (int i = 0; i < s2.length(); i++) {
			if (h1.containsKey(s2.charAt(i))) {
				int cnt = h.get(s2.charAt(i));
				if (cnt >= 1) {
					count--;
					if (cnt - 1 == 0) {
						h1.remove(s2.charAt(i));
					} else
						h1.put(s2.charAt(i), cnt - 1);
				}
			} else {
				h1 = (HashMap<Character, Integer>) h.clone();
				count = s1count;
			}
			if (count == 0) {
				return true;
			}
		}
		return false;

	}

	// good method -2nd Method
	static int[] Histogram(String a, int idx, int length) {
		int buffSize = (int) ('z' - 'A' + 1);
		int[] hist = new int[buffSize];
		for (int i = 0; i < length; i++)
			hist[a.charAt(i + idx) - 'A']++;
		return hist;
	}

	static boolean SameHist(int[] h1, int[] h2) {
		for (int i = 0; i < h1.length; i++)
			if (h1[i] != h2[i])
				return false;
		return true;
	}

	/*
	 * here take a's length and build hist for both string a and string str for
	 * length a. compare counts.
	 */
	public static boolean ContainsAnagramSlidingWindow(String a, String str) {
		if (a == "")
			return true;
		if (a.length() > str.length())
			return false;

		int[] histA = Histogram(a, 0, a.length()); // a's total histogram
		int[] histStr = Histogram(str, 0, a.length()); // str's partial
														// histogram
		int i = 0;
		while (true) {
			// Compare str's partial histogram to a's histogram
			if (SameHist(histA, histStr))
				return true;
			if (i == str.length() - a.length())
				break;

			// Move window one step ahead
			histStr[str.charAt(i) - 'A']--;// (remove the frst character in the
											// window)
			histStr[str.charAt(i + a.length()) - 'A']++;// (Add the new
														// character in the
														// window)
			i++;
		}

		return false;
	}
}