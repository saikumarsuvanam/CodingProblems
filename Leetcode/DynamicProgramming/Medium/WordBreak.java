package Medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-break/description/ 139. Word Break
/*
 *  Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak {

	public boolean wordBreak(String s, List<String> dict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

	public static void main(String[] args) {
		WordBreak b = new WordBreak();
		List<String> wordDict = new ArrayList<String>();

		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("b");
		wordDict.add("cd");
		String s = "leetcode";
		// boolean dp[][] = new boolean[s.length()+1][s.length()+1];

		System.out.println(b.wordBreak(s, wordDict));
	}

}
