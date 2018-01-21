
/*

Return the length of longest possible chunked palindrome string.

Examples :

Input : VOLVO
Output : 3
Explanation :
(VO)L(VO)


Input : merchant
Output : 1

Explanation : No chunks possible.

Input :

ghiabcdefhelloadamhelloabcdefghi

Output : 7

Explanation :

(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)
*/
import java.util.*;
public class longest_palindrom_chuncks_in_a_string {public static void main(String[] args) {
	        //System.out.println(LCP(null));
	        //System.out.println(LCP(""));
	       // System.out.println(LCP("V"));
	       // System.out.println(LCP("VOLVO"));
	        //System.out.println(LCP("VOLVOV"));
	        //System.out.println(LCP("ghiabcdefhelloadamhelloabcdefghi"));
	        //System.out.println(LCP("ghiabcdefhelloadamhelloabcdefghik"));
	        //System.out.println(LCP("ghiabcdefhelloadamhelloabcdefghi"));
	       // String s="ghiabcdefhelloadamhelloabcdefghi";
	       String s="antaprezatepzapreanta";
	  
	 StringBuffer leftsb=new StringBuffer();
	 StringBuffer rightsb=new StringBuffer();
	 
	        
	 System.out.println(LCP(s));
	        if(s.length()%2==0)
	        System.out.println(LCCP(s,0,0,s.length()-1,s.length()-1,0,leftsb,rightsb));
	        else{
	        	
	        	System.out.println(LCCP(s,0,0,s.length()-1,s.length()-1,1,leftsb,rightsb));
	        }
	        
	    }
	    
	   
static String LCCP(String s,int lstart,int lend,int rstart,int rend,int length,StringBuffer lb,StringBuffer rb){
	
	
	if(lend>=rstart){
		lb.append("(");
		lb.append(s.substring(lstart,rend+1));
		lb.append(")");
		lb.append(rb);
	
		System.out.println(length);
		return lb.toString();
		
	}
	
	else if(s.substring(lstart,lend+1).equals(s.substring(rstart,rend+1))){
		
		length=length+2;
		
		lb.append("(");
		lb.append(s.substring(lstart,lend+1));
		lb.append(")");
		rb.insert(0,"(");
		
		rb.insert(1,s.substring(lstart,lend+1));
		rb.insert(1+s.substring(lstart,lend+1).length(), ")");
		
		
		return LCCP(s,lend+1,lend+1,rstart-1,rstart-1, length,lb,rb);
		
	}
	

	else{
		if(lend+1>=rstart){
			
			
			
			length=length+1;
		}
		
		return LCCP(s,lstart,lend+1,rstart-1,rend,length,lb,rb);
		
	}
	
	
	
}








//My main good solution
		private static int LCP(String s) {
			    	StringBuffer ls=new StringBuffer();
			    	StringBuffer rs=new StringBuffer();
				    int length=0;
				    int k=s.length()-1;
				    int l=0;
			 
			        for(int i=l; i<s.length(); i++){
			        	
			        	
			        	for(int j=k; j>i; j--){
							if(s.substring(l,i+1).equals(s.substring(j,k+1))){
						    ls.append("(");
						    ls.append(s.substring(l,i+1));
						    ls.append(")");
							rs.insert(0,")");
							rs.insert(0,s.substring(l,i+1));
							rs.insert(0,"(");
							length=length+2;
							l=i+1;
							k=j-1;
							if(l==j) {
								ls.append(rs);
								System.out.println(ls.toString());
								return length;
							
							}
		
			        		}
			           }
			        }
			        ls.append("(");
			        ls.append(s.substring(l,k+1));
			        ls.append(")");
			        ls.append(rs);
			    	System.out.println(ls.toString());
			    	return length+1;
		}
	    	
public int Anothermethod_iterative_longestPalindrome(String s){
    if(s.length()==0){
        return 0;
    }
    int start=0;
    int end=s.length();
    int length=1;
    if(end%2==0)
    length=0;
    int flag=0;
    char[] charString=s.toCharArray();
    
    for(int i=1; i<=s.length()/2;i++){
         if(charString[i-1]==charString[end-1]){
             length=length+2;
         }
         else if(s.substring(start,i).equals(s.substring(end-i, end))){
           flag=s.substring(start,i).length();
        }
    }
    length=length+flag*2;
    return length;
}

	}

