package anonymous;

import java.util.HashSet;


/*Find numbers which are palindromic in both their decimal and octal 
 * representations
 
ex:121 (171 otcal) for example is a palindromic in both bases 
1+7*8+1*8*8=121
*/
public class palindromes_in_both_octal_and_decimal {
	
	
    public static void main(String[] args){
       
      //generate palindrome numbers of lengthup to 5  
    	int produce;
    	// if there are total 10 numbers in decimal from 0-9 are there 
    	//then no.of palindromes of length 1 will be -9
    	//no.of palindromes of length 2 will be -9
    	//no of palindromes of length 3 will be -9*10
    	//no of palindromes of length 4 will be -9*10
    	//no of palindromes of lenght 5 will be -9*10*10
    	//this is like a pattern
    //total for  total no of palindromes of all lengths up to 5
    	//will be 1098.
    	int maxlength=100;//max length u want to form a palindrome
	 for(int i=1; i<maxlength; i++){
		 int decimal=10;
		 int octal=8;
		 HashSet<String> decimalset=new HashSet();
		 generate_palindrome(i,"",decimal,decimalset);
		 HashSet<String> octalset=new HashSet();
		 generate_palindrome(i,"",octal,octalset);
		 for (String Octalnumber : octalset) {
		     String decimalnumber=octal_to_decimal(Octalnumber);
		     if(decimalset.contains(decimalnumber)){
				  System.out.println("decimal number is "+decimalnumber+" and"+" octal number is "+Octalnumber);
			  }
			}
		
	 }
	
    }
    
    static String octal_to_decimal(String octal){
    	Double d=new Double(0);
    	for(int i=octal.length()-1; i>=0;i--){
    		 String octalstring=""+octal.charAt(i);
    		 int octaldigit=Integer.parseInt(octalstring);
    		 d=d+octaldigit*Math.pow(8,octal.length()-1-i);
    	}
   
     return d.toString().substring(0, d.toString().length()-2);
    
    	
    }
  
   static void  generate_palindrome(int length,String s,int radix,HashSet set){
	   if(s.length()>=length/2.0){
	   int last;
	   if(length%2==0){
		   last=s.length()-1;}
	   else{last=s.length()-2;
	   //produce reverse and append
	   }
	  StringBuilder reverse=new StringBuilder();
    		for(int j=last;j>=0;j--){
    			reverse.append(s.charAt(j));
    		}
            set.add(s+reverse.toString());
    		//System.out.println(s+reverse.toString());
    		return;
    	}
	
    	else{
	   for(int i=0; i<radix;i++){
    		if(i==0 && s==""){
    		continue;
    	    }
    		else generate_palindrome(length,s+i,radix,set);
    	}
    	}
    }
}
