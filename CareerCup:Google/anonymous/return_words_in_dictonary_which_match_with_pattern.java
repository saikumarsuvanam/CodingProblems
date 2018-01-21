
/*https://www.careercup.com/question?id=5704645247762432
Given a Pattern and a dictionary, print out all the strings that match the pattern.
where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).

 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf"
2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"

*/

import java.util.*;
public class return_words_in_dictonary_which_match_with_pattern {

	public static ArrayList<String> find_matches(String pattern, String[] dictionary, ArrayList<String> result){ 
		HashMap hm=new HashMap();
		for(String word:dictionary){
			if(word.length()==pattern.length()){
			   for(int i=0; i<word.length();i++){
				   if(!hm.containsKey(word.charAt(i))){
					   if(!hm.containsValue(pattern.charAt(i))){
						   if(i==word.length()-1) result.add(word);
						   hm.put(word.charAt(i),pattern.charAt(i));
					   }   
					   else break;
				   }
				   else if(!((Character)hm.get(word.charAt(i))==pattern.charAt(i))){
					   break;
				   }
				   
				   else {
					   if(i==word.length()-1) result.add(word);
					   continue;
					  
				   }
			   }
			   hm.clear();
			   
			}
			  
		}
		return result;
	
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String pattern="eghft";
        String[]dictionary=new String[]{"cdd", "paa", "hgfdt" ,"paa"};
		ArrayList<String> result=new ArrayList<String>();
		result=find_matches(pattern,dictionary, result);
		System.out.println(result);
	}
	
	//Another solution from career cup
	
	
	/*public static void main(String[] args) {
        String pattern = "eh";
        String[] dictionary = { "hf","cdf", "too", "hfgdt", "paa" };
        System.out.println(findMatch(dictionary, pattern));
    }

    private static List<String> findMatch(String[] dictionary, String pattern) {
        List<String> result = new ArrayList<String>();
        String encodePattern = encode(pattern);
        for (String s : dictionary) {
            if (encode(s).equals(encodePattern)) {
                result.add(s);
            }
        }
        return result;
    }

    private static String encode(String pattern) {
        Map<Character, Integer> encoder = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (char c : pattern.toCharArray()) {
            if (null == encoder.get(c)) {
                encoder.put(c, counter++);
            }
            sb.append(encoder.get(c));
        }
        return sb.toString();
    }	
*/
}
