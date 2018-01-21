package Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Stringshackerrank {



	    static String isValid(String s){
	        // Complete this function
	        HashMap map=new HashMap();
	        for(int i=0; i<s.length();i++){
	            if(!map.containsKey(s.charAt(i))){
	                   map.put(s.charAt(i),1);
	            }
	               else {
	                   int count= (int)map.get(s.charAt(i));
	                   count=count+1;
	                   map.put(s.charAt(i),count);
	               }
	        }
	        int first=0;
	        int second=0;
	        int prev=-1;
	        int nextprev=-1;
	               
	         List<Integer> mapValues = new ArrayList<>(map.values());
	          Collections.sort(mapValues);
	        
	              for (Integer i : mapValues) {
	                
	                if(prev==-1){
	                  prev=i;
	                  first=first+1;
	              }
	              else if(prev==i){
	                  first=first+1;
	                   
	                  continue;
	              } 
	              else if(nextprev==-1){
	                  nextprev=i;
	                  second=second+1;
	              }    
	              else if(nextprev==i){
	                   second=second+1;
	                  
	                  continue;
	              }    
	                  
	                 
	                 
	                  else if(( Math.abs(second-first)>1)||(first>1&&second>=2)||(second>1&&first>=2))
{
	                      return "NO";
	                      
	                  }
	                  else{
	                      return "NO";
	                  }
	                  
	                 
	                 
	}
	       
            
	           if  ((first>1&&second>=2)||(second>1&&first>=2))
{
	                      return "NO";
	                      
	                  } 
	        
	        return "YES";
	        
	    }


	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        String result = isValid(s);
	      
	        System.out.println(result);
	    }
	}


