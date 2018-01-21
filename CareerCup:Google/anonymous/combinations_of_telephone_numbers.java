
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

*/






import java.util.*;
public class combinations_of_telephone_numbers {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public static void main(String [] args){
    	
    	
    	System.out.println(letterCombinations("23"));
    	
    }
    public static  List<String> letterCombinations(String digits) {
    
            ArrayList<String> result=new ArrayList<String>();
            letterComb(digits,"",result);
            return result;
    }


    static void    letterComb(String digits,String s,ArrayList<String> result){           
            if(digits.length()==0) {
            
                if(!s.equals(""))
                
                result.add(s);
            }
            else{
            
                char a=digits.charAt(0);
                String chars= KEYS[a-'0'];
                
                for(int j=0; j<chars.length(); j++){
                   letterComb(digits.substring(1),s+chars.charAt(j),result);
                }
           }
   }
}