import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class pattern_camel_case_matching_dictionary_words {
	
public static void main(String[] args){	
	String[] camelCaseWords = { "HelloMars", "HelloWorld", "HelloWorldMars", "HiHo" ,"HiW"};
		String pattern="HiHe";
		pattern_camel_case_matching_dictionary_words p=new pattern_camel_case_matching_dictionary_words();
		CCTrieNode t=p.new CCTrieNode();
		System.out.println(t.matchesCCPattern(camelCaseWords, pattern));
	}

   //using CtCILibrary trienode structure

      //but for this 











               private class CCTrieNode {
			   private CCTrieNode[] next = new CCTrieNode[26];
			   private List<Integer> matchesIndex = new ArrayList<>();

			   private void insert(String words, int index) {
			      matchesIndex.add(index);
			      if (words.isEmpty()) return;

			      CCTrieNode nextWord = next[words.charAt(0) - 'A'];
			      if (nextWord == null) {
			        nextWord = new CCTrieNode();
			        next[words.charAt(0) - 'A'] = nextWord;
			      }
			      int nextWordStart = 0;
			      while (++nextWordStart < words.length()) {
			        if (Character.isUpperCase(words.charAt(nextWordStart))) break;
			      }
			      nextWord.insert(words.substring(nextWordStart), index);
			    }
			    
			    
			    private List<String> matchesCCPattern(String[] words, String pattern) {
				    CCTrieNode root = new CCTrieNode();
				    for (int i = 0; i < words.length; i++) {
				      root.insert(words[i], i);
				    }

				    List<String> matchingWords = new ArrayList<>();
				    for (int index : root.indexesForCCPattern(pattern)) {
				    	System.out.println(index);
				      if (matchesPattern(words[index], pattern)) {
				    	  System.out.println(1);
				        matchingWords.add(words[index]);
				      }
				    }
				    return matchingWords;
				  }

				  private boolean matchesPattern(String word, String pattern) {
				    int wordIndex = 0, patternIndex = 0;
				    while (wordIndex < word.length() && patternIndex < pattern.length()) {
				      char wordChar = word.charAt(wordIndex), patternChar = pattern.charAt(patternIndex);
				      if (Character.isUpperCase(wordChar) || !Character.isUpperCase(patternChar)) {
				        if (wordChar != patternChar) return false;
				        patternIndex++;
				      }
				      wordIndex++;
				    }
				    return patternIndex == pattern.length();
				  }


			     private List<Integer> indexesForCCPattern(String pattern) {
			      if (pattern.isEmpty()) return matchesIndex;
			     System.out.println( pattern.charAt(0) - 'A');
			      CCTrieNode nextWordNode = next[pattern.charAt(0) - 'A'];
			      if (nextWordNode == null) {
			    	  //System.out.println(2);
			        return Collections.emptyList();
			      }
			      int nextWordStart = 0;
			      while (++nextWordStart < pattern.length()) {
			        if (Character.isUpperCase(pattern.charAt(nextWordStart))) break;
			      }
			      return nextWordNode.indexesForCCPattern(pattern.substring(nextWordStart));
			    }
			  }
}