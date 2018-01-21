/* 
Find longest substring with "m" unique characters in a given string.

input: aabacbeabbed
output:
4 (aaba) for 2 unique characters
6 (aabacb) for 3 unique characters

*/
//Java Implementation. Time: O(N); Space: O(N); HashMap and Moving Window idea.
package Strings;

import java.util.HashMap;
import java.util.Map;

public class longest_substring_with_m_unique_charcaters {

	public static void main(String[] args) {
		longest_substring_with_m_unique_charcaters code = new longest_substring_with_m_unique_charcaters();
		System.out.println("Enter your required unique character count");
		// Scanner scan = new Scanner(System.in);
		// String s = scan.next();
		// int i = scan.nextInt();
		System.out.println(code.getLSKQC("aabacbeaabacbb", 2));
		System.out.println(code.getLSKQC1("aabacbeaabacbb", 2));
	}

	public String getLSKQC(String source, int m) {
		if (source == null || source.length() == 0 || m > source.length() || m <= 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		int start = 0;
		int end = 0;
		int max = Integer.MIN_VALUE;
		String MaxString = "";
		for (int i = 0; i < source.length(); i++) {
			if (map.containsKey(source.charAt(i))) {
				map.put(source.charAt(i), map.get(source.charAt(i)) + 1);
			} else if (!map.containsKey(source.charAt(i))) {
				if (map.size() + 1 > m) {
					while (map.size() >= m) {
						if (map.containsKey(source.charAt(start))) {
							if (map.get(source.charAt(start)) == 1) {
								map.remove(source.charAt(start));

							} else
								map.put(source.charAt(start), map.get(source.charAt(start)) - 1);
						}
						start++;
					}

				}
				map.put(source.charAt(i), 1);

			}

			res = source.substring(start, i) + source.charAt(i);

			if (res.length() > max && map.size() == m) {
				max = res.length();
				MaxString = res;
			}
		}

		return MaxString;
	}

	// same procedure different style of coding
	public String getLSKQC1(String source, int m) {
		if (source == null || source.length() == 0 || m > source.length() || m <= 0) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		int left = 0;
		int right = 0;

		for (right = 0; right < source.length(); right++) {
			char curt = source.charAt(right);
			if (!map.containsKey(curt)) {
				map.put(curt, 1);
			} else {
				map.put(curt, map.get(curt) + 1);
			}

			if (map.keySet().size() == m + 1) {
				if (right - left > res.length()) {
					res = source.substring(left, right);
				}
				while (map.keySet().size() > m) {
					char c = source.charAt(left++);
					if (map.get(c) == 1) {
						map.remove(c);
					} else {
						map.put(c, map.get(c) - 1);
					}
				}
			}
		}
		if (map.keySet().size() == m && right - left > res.length()) {
			res = source.substring(left, right);
		}
		return res;
	}
}
