package Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//0(n*n *n!) time
//http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
/*1. Take the previously printed permutation and find the 
 * rightmost character in it, which is smaller than its next character. 
 * Let us call this character as ‘first character’.

2. Now find the ceiling of the ‘first character’. 
Ceiling is the smallest character on right of ‘first character’, which is 
greater than ‘first character’. Let us call the ceil character as ‘second 
character’.

3. Swap the two characters found in above 2 steps.

4. then just the reverse the substring after the origianl index of first
character because the question asked without duplicates
for duplicates you need to sort the substring
 * 
 */
public class generate_all_permutaitons_of_string_in_sorted_order {
	public static void main(String[] args) {
		String s = "BBDC";
		sorted_permutations(s);

	}

	static void sorted_permutations(String s) {
		String sortedString = sortedString(s);// get sortedString
		System.out.println(sortedString);
		int count = 0;
		/*
		 * get the rightmost firstmost character which is small than the next
		 * character after it
		 */
		while (true) {
			count++;
			int length = sortedString.length();
			int firstcharacterIndex;
			int secondcharacterIndex;
			int i;
			for (i = length - 2; i >= 0; i--) {
				char firstcharacter = sortedString.charAt(i);
				if (firstcharacter < sortedString.charAt(i + 1)) {
					break;
				}
			}
			if (i == -1)
				break;
			char firstcharacter = sortedString.charAt(i);

			/*
			 * get the smallest character which is greater than the first
			 * character after it on right side
			 */
			int j;
			firstcharacterIndex = i;
			secondcharacterIndex = i + 1;
			for (j = i + 1; j < length; j++) {
				char second = sortedString.charAt(j);
				if (firstcharacter < second && sortedString.charAt(secondcharacterIndex) > second) {
					secondcharacterIndex = j;
				}
			}
			String swappedString = swap(sortedString, firstcharacterIndex, secondcharacterIndex);
			String toreverse = swappedString.substring(firstcharacterIndex + 1);
			String reversed = reverse(toreverse);
			sortedString = swappedString.substring(0, firstcharacterIndex + 1) + reversed;
			System.out.println(sortedString);
		}
		System.out.println(count);
	}

	static String swap(String s, int first, int second) {

		String[] input = s.split("");
		List<String> list = Arrays.asList(input);

		String temp = list.get(first);
		list.set(first, list.get(second));
		list.set(second, temp);
		String sortedString = "";
		for (Iterator i = list.iterator(); i.hasNext();) {
			sortedString = sortedString + i.next();
		}
		return sortedString;
	}

	static String reverse(String str) {
		int h = str.length() - 1;
		int l = 0;
		while (l < h) {
			str = swap(str, l, h);
			l++;
			h--;
		}
		return str;
	}

	static String sortedString(String s) {
		String[] input = s.split("");
		List<String> list = Arrays.asList(input);
		Collections.sort(list);
		String sortedString = "";

		for (Iterator i = list.iterator(); i.hasNext();) {
			sortedString = sortedString + i.next();
		}
		return sortedString;
	}
}
