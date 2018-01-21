import java.util.ArrayList;

public class devuda {
    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    public devuda( final String str ){
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }
    
    
    public static void main (String args[])
    {
        devuda combobj= new devuda("wxyz");
        System.out.println("");
        System.out.println("");
        System.out.println("All possible combinations are :  ");
        ArrayList<String> a=new ArrayList<String> ();
        combine("abc","",3, a);
       
        
    }
    
    
   
    
 
    private static void combine(String c, String prefix,int k,ArrayList<String> a){
    	if(k==0){
    		
    		System.out.println(prefix);
    	
    		return;
    		
    	}
    	
    	 for (int i = 0; i < c.length(); i++) {
             
             // Next character of input added
    		 
    		 
             String newPrefix =  prefix+ c.charAt(i);
      
          
             
              // k is decreased, because we have added a new character
            combine(c.substring(0,i)+c.substring(i+1),newPrefix,k - 1,a); 
       
        	
        	
       
            
        }
    }
} 