

/* Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * You may assume the dictionary does not contain duplicate words.
 * Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. 
 
 */
import java.util.*;
//Good solution
public class  word_break_in_to_sentences{


public List<String> wordBreak(String s, List<String> wordDict) {
    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
}       

public static void main(String[] args){
	
	

	
	
}


// DFS function returns an array including all substrings derived from s.
List<String> DFS(String s,List<String> wordDict, HashMap<String, LinkedList<String>>map) {
    if (map.containsKey(s)) 
        return map.get(s);
        
    LinkedList<String>res = new LinkedList<String>();     
    if (s.length() == 0) {
        res.add("");
        return res;
    }               
    for (int i=0; i<s.length(); i++) {
        if(wordDict.contains(s.substring(0,i+1))) {
            String word=s.substring(0,i+1);
            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
            for (String sub : sublist) 
                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
        }
    }       
    map.put(s, res);
    return res;
}}