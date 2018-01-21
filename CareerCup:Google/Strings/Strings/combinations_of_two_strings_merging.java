package Strings;

//no of combinations is (m+nCn) means m+n of n (6c3=20)where m>n.
/*
Question Given two strings s1 and s2, combine the characters in the strings and 
maintain the sequence of characters
Follow-up If s1 has a length of m and s2 has a length of n, how many ways the 
strings could be merged. Figure out the formula F(m, n) = ?*/
public class combinations_of_two_strings_merging {

	public static void main(String[] args) {
		String s1 = "h43";
		String s2 = "f3ed";
		merge(s1, s2, "", 0, 0);
		System.out.println(count);
	}

	static int count = 0;

	static void merge(String s1, String s2, String mergedString, int i1, int i2) {

		if (mergedString.length() == s1.length() + s2.length()) {
			count++;
			System.out.println(mergedString);
			return;
		}

		if (i1 < s1.length())
			merge(s1, s2, mergedString + s1.charAt(i1), i1 + 1, i2);
		if (i2 < s2.length())
			merge(s1, s2, mergedString + s2.charAt(i2), i1, i2 + 1);

	}
}
