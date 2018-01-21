import java.util.*;


public class ReducedWordInDictionary {


	    private static TreeSet<String> dictionary = new TreeSet<String>(LengthComparator.INSTANCE);
	    static {
	        dictionary.add("a");
	        dictionary.add("an");
	        dictionary.add("be");
	        dictionary.add("cat");
	        dictionary.add("car");
	        dictionary.add("dear");
	        dictionary.add("down");
	        dictionary.add("fire");
	        dictionary.add("hire");
	        dictionary.add("product");
	        dictionary.add("row");
	        dictionary.add("report");
	        dictionary.add("cataly");
	        dictionary.add("product");   
	        dictionary.add("fibre");
	        dictionary.add("fib");
	    }
	    
	    public static void main(String[] args) { 
	    	
	    	
	    	int k=5;
	    	k>>=1;
	    	System.out.println(k);
	    	for(int i=8; i>0;i>>=1 ){
	    		
	    		if((i&1)==1){
	    			
	    			System.out.println("gfg");
	    			
	    		}
	    			
	    			
	    			
	    		
	    	}
	    	
	    	System.out.println( dictionary);
	        System.out.println(find(null, dictionary));
	        System.out.println(find("", dictionary));
	        System.out.println(find("a", dictionary));
	        System.out.println(find("b", dictionary));
	        System.out.println(find("catalysis", dictionary));
	        System.out.println(find("preowned", dictionary));
	        System.out.println(find("preregistered-owned", dictionary));
	        System.out.println(find("product", dictionary));
	        System.out.println(find("fibree", dictionary));        
	    }
	    
	    private static String find(String word, TreeSet<String> dictionary) {
	        
	        if (word == null || word.isEmpty()) return null;

	        // otherwise
	        int length = word.length();
	        
	        // otherwise
	        Iterator<String> dit = dictionary.descendingIterator();
	        boolean isCandidate = false;
	        while(dit.hasNext()) {
	            String s = dit.next();

	            if (!isCandidate && s.length() > length) continue;
	                        
	            // otherwise
	           isCandidate = true;
	            
	            // otherwise
	            if (s == null || s.isEmpty()) break;

	            // otherwise
	            if (match(s, word)) return s;
	        }
	        
	        return null;
	    }
	    
	    private static boolean match(String word, String originalWord) {
	        
	        int currentIndex = 0;
	        for (int i = 0; i < word.length(); i++) {
	            char c1 = word.charAt(i);
	            
	            int j = currentIndex;
	            for (; j < originalWord.length(); j++) {
	                char c2 = originalWord.charAt(j);
	                
	                if (c1 != c2) {
	                	
	                	
	                    continue;
	                   
	                }
	                else { 
	                	if(j==originalWord.length()-1)
	                		return true;
	                	break;
	                }
	                	
	                
	                
	                // otherwise, continue
	            }
	            
	           
	        }
	        
	        return true;
	    }
	    
	    private static class LengthComparator implements Comparator<String> {

	        private static Comparator<String> INSTANCE = new LengthComparator();
	        
	        @Override
	        public int compare(String s1, String s2) {
	            
	            if (s1 == null) return s2 == null? 0: -1;
	            
	            if (s2 == null) return 1;
	            
	            int l1 = s1.length();
	            int l2 = s2.length();
	            
	            if (l1 == l2) return s1.compareTo(s2);
	            
	            return l1 > l2? 1: -1;            
	        }
	    }
	}	
	
	
	

