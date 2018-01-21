	import java.util.ArrayList;
public class dd {


	    private StringBuilder output = new StringBuilder();
	    private final String inputstring;
	    public dd( final String str ){
	        inputstring = str;
	        System.out.println("The input string  is  : " + inputstring);
	    }
	    
	    
	    public static void main (String args[])
	    {
	        
	     
	        System.out.println("All possible combinations are :  ");
	        ArrayList<String> a=new ArrayList<String> ();
	        combine("abcd");
	       
	        
	    }
	    
 static void combine(String c){
	    
	    	combine1("", c);
	    	
	    }
	    
	    
 private static void combine1(String c,String d){
	    	if(d.length()==0){
	    		
	    	String[] s=c.split(" ");
	    	ArrayList b=new ArrayList();
	    	for(String a:s)
	    	    b.add(a);
	    		b.remove(b.get(0));
	    		System.out.println(b);
	    	    return ;
	    	}
	    	for (int i = 0; i < d.length(); i++) {
	             combine1(c+" "+d.substring(0,i+1),d.substring(i+1));
	      }
	    }
	} 

