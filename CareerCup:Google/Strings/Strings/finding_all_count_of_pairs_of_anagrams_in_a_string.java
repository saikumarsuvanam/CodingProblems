package Strings;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class finding_all_count_of_pairs_of_anagrams_in_a_string {



	    
	

	    static int sherlockAndAnagrams(String s){
	                HashMap<Long,Integer> map=new HashMap<Long,Integer>();
	                
		            for(int i=0; i<s.length();i++){
		            	HashMap<Character,Integer> freq=new HashMap<Character,Integer>();
		            	String prev="";
		                for(int j=i; j<s.length();j++){
		                    
		                	if (!freq.containsKey(s.charAt(j))){
		                		freq.put(s.charAt(i), 1);
		                		
		                	}
		                	else{
		                		int val=freq.get(s.charAt(i));
		                		val=val+1;
		                		freq.put(s.charAt(i),val);
		                	}
		                	
		                	Long h=hash(freq);
		                insert(map, h);
		                }
		               
		            }
		            int sum=0;
	                for(Entry<Long,Integer> e: map.entrySet()){
	                	sum=(int) (sum+(e.getValue()*(e.getValue()-1)/2));
	                	
	                }
	                
		        return sum;
		            
		        }
		        
	    

	    
	    
	 
	static  void insert(HashMap<Long,Integer> h, Long k){
		if(!h.containsKey(k)){
			h.put(k, 1);
			
		}
		else{
			int  l=h.get(k);
			l++;
			h.put(k, l);
		}
		
	}

		
		   
		   
		   
		   
		   public static long hash(      HashMap<Character,Integer> freq)
			{
			   
			   long t = 1;
				long ret = 0;
			 long h=0;
				long mod =1000000007, p =999983;
				for(Entry<Character, Integer> e: freq.entrySet()){
                              
               	
				/*   h =(h*p+e.getValue()+1)%mod;
					if(h < 0) h +=mod;}
				*/
				
					ret += t *  e.getValue();
			//C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
			//ORIGINAL LINE: t=t*(long long unsigned)1000003;
					t = (t * (long)1000003);
				
				}
			return ret;	
			}
				
			
		
		    
		   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            String s = in.next();
	            int result = sherlockAndAnagrams(s);
	            System.out.println(result);
	           
	        }
	    }
	}
