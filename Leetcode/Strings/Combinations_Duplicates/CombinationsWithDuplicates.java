package Combinations_Duplicates;



import java.util.ArrayList;
import java.util.HashMap;



public class CombinationsWithDuplicates {
	//Build the frequency map for characters in the String
	public static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	/**
	 * l- ArrayList contains Unique characters in the given String.
	 * map-Hashmap contains keys as unique characters and values as frequency in the original String.
	 * remain-int varaible -it will say how many characters you want. remain=r in (n c r).
	 * remaining type of int. on the way to reach remain
	 * result- to append all the combinations in the list
	 */
	public static void printCombs(HashMap<Character, Integer> map, String prefix, int remaining,
			ArrayList<String> result, ArrayList<Character> l, int start,int remain) {
		if (remaining == remain) {
			result.add(prefix);
			return;
		}
		if (l.size() > start) {
			int count = map.get(l.get(start));
			Character c = l.get(start);
			//include the character if its count is greater than zero
			if (count > 0) {
				map.put(c, count - 1);
				printCombs(map, prefix + c, remaining+1, result, l, start,remain);
				map.put(c, count);
			}
			//exclude the character
			printCombs(map, prefix, remaining, result, l, start + 1,remain);
		}
	}

	public static ArrayList<String> printCombs(String s,int r) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		ArrayList<Character> l = new ArrayList<Character>();
		for (Character c : map.keySet()) {
			l.add(c);
		}
		printCombs(map, "", 0, result, l, 0,r);
		return result;
	}
    //ncr 
	public static void main(String[] args) {
		String s = "abbcdrwrwerwedwedwecdwaads";
		int n=s.length();
		int r=2;
		ArrayList<String> result = printCombs(s,r);
		System.out.println("Count: " + result.size());
		for (String re : result) {
			System.out.println(re);
		}
	}

}
