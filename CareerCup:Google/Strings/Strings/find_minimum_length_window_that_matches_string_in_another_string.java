package Strings;

/*http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 *  Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
For Example:

Input :  string = "this is a test string"
         pattern = "tist"
Output :  Minimum window is "t stri"
Explanation: "t stri" contains all the characters
              of pattern.

Input :  string = "geeksforgeeks"
         pattern = "ork" 
Output :  Minimum window is "ksfor"

Recommended: Please solve it on "PRACTICE" first, before moving on to the solution.

Method 1 ( Brute force solution )
1- Generate all substrings of string1 (“this is a test string”)
2- For each substring, check whether the substring contains all characters of string2 (“tist”)
3- Finally, print the smallest substring containing all characters of string2.

 
Method 2 ( Efficient Solution )

1- First check if length of string is less than
   the length of given pattern, if yes
       then "no such window can exist ".
2- Store the occurrence of characters of given 
   pattern in a hash_pat[].
3- Start matching the characters of pattern with 
   the characters of string i.e. increment count 
   if a character matches
4- Check if (count == length of pattern ) this 
   means a window is found
5- If such window found, try to minimize it by 
   removing extra characters from beginning of
   current window.
6- Update min_length.
7- Print the minimum length window.

 */
public class find_minimum_length_window_that_matches_string_in_another_string {
		public static void main(String[] args) {
			
			String str= "this is a test string";
		    String pattern="tist";
			
			System.out.println(find_minumum_window(str,pattern));
		}
		static String find_minumum_window(String str,String pat){
			String s=str;
			String t=pat;
			int[] needToFind = new int[256];
		    int[] hasFound = new int[256];

		    for(int i = 0; i < t.length(); ++i) {
		       needToFind[t.charAt(i)]++;
		    }

		    int count = 0;
		    int minWindowSize = Integer.MAX_VALUE;
		    int start = 0, end = -1;
		    String window = "";

		    while (++end < s.length()) {
		        char c = s.charAt(end);
		        if(++hasFound[c] <= needToFind[c]) {
		           count++;
		        }

		        if(count < t.length()) continue;
		        while (hasFound[s.charAt(start)] > needToFind[s.charAt(start)]) {
		           hasFound[s.charAt(start++)]--;
		           
		        }

		        if(end - start + 1 < minWindowSize) {
		           minWindowSize = end - start + 1;
		           window = s.substring(start, end + 1);
		        }
		    }
		    return window;
		}
}
