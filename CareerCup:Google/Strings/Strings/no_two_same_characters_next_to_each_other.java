package Strings;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*http://www.zrzahid.com/rearrange-characters-in-string-with-no-adjacent-duplicate-characters/
 * http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
 * Write a function
bool fancy_shuffle(char* s);

which rearranges characters in the string given as input, in such a way that no 
same character occurs twice in a row (that is, next to each other).
If such rearrangement is not possible, the function should return false.
 */
public class no_two_same_characters_next_to_each_other {

	// if any character count is greater than (n/2)+1 where n is the length of
	// string
	// then rearrangement is not possible. other wise possible.will do using
	// heap.
	public static void main(String[] args) {
		String s = "aaaabbbcccccc";
		// first check whether possible or not
		no_two_same_characters_next_to_each_other t = new no_two_same_characters_next_to_each_other();
		System.out.println(isPossible(s));
		if (isPossible(s)) {// if rearrange possible
			System.out.println(t.rearrange(s, new StringBuilder()));
		}
	}

	static boolean isPossible(String s) {
		HashMap charcount = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			if (!charcount.containsKey(s.charAt(i)))
				charcount.put(s.charAt(i), 1);
			else {
				int count = (int) charcount.get(s.charAt(i));
				count++;
				Double y = (double) (s.length() / 2.0);
				Double x = Math.ceil(y);
				if (count > x)
					return false;
				charcount.put(s.charAt(i), count);
			}
		}
		return true;
	}

	class character implements Comparable<character> {
		character(char c, int count) {
			freq = count;
			ch = c;
		}

		int freq;
		char ch;

		public int compareTo(character c) {
			// TODO Auto-generated method stub
			if (c.freq > freq) {
				return 1;
			} else if (c.freq < freq) {
				return -1;
			} else
				return 0;
		}

	}

	String rearrange(String s, StringBuilder rearrangedString) {
		// will use max heap
		PriorityQueue<character> q = new PriorityQueue<character>();

		HashMap<Character, Integer> charcount = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!charcount.containsKey(s.charAt(i))) {
				charcount.put(s.charAt(i), 1);
			} else {
				int count = (int) charcount.get(s.charAt(i));
				count++;

				charcount.put(s.charAt(i), count);
			}
		}
		for (Entry<Character, Integer> entry : charcount.entrySet()) {
			q.add(new character(entry.getKey(), entry.getValue()));
		}

		while (!q.isEmpty()) {
			character first = q.poll();
			first.freq--;
			rearrangedString.append(first.ch);
			if (!q.isEmpty()) {
				character second = q.poll();
				second.freq--;
				rearrangedString.append(second.ch);
				if (second.freq != 0) {
					q.add(second);
				}
			}
			if (first.freq != 0)
				q.add(first);

		}
		return rearrangedString.toString();

	}

}