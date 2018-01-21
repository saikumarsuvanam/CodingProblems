package Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class substring_checking {



	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	         Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		       
		            String s = in.next();
	      
	        
	        int x=method(s, n);
	     
	        System.out.println(x);
	        }

	  static  int  method(String s,int n){
	    	
		      
		        int dp[][]=new int[s.length()][26];
		        dp[0][s.charAt(0)-'A']=1;
		        for(int i=1; i<s.length();i++){
		        	
		        	for(int l=0; l<26;l++){
		    			dp[i][l]=dp[i-1][l];
		    		}
		        dp[i][s.charAt(i)-'A']=	 dp[i][s.charAt(i)-'A']+1;
		        }
		        int dp1[][]=new int[s.length()][26];
		       
		        int k=0;
		        dp1[k][s.charAt(s.length()-1)-'A']=1;
		        k=k+1;
		    	for(int j=s.length()-2;j>=0;j--){
		    		for(int l=0; l<26;l++){
		    			dp1[k][l]=dp1[k-1][l];
		    		}
		    		dp1[k][s.charAt(j)-'A']=dp1[k][s.charAt(j)-'A']+1;
		    		k++;
		    	}
		        
		    	int min=Integer.MAX_VALUE;
		    	for(int i=0; i<s.length();i++){
		    		if(dp[i]['G'-'A']>n/4 ||
			    			dp[i]['A'-'A']>n/4 ||
			    			dp[i]['C'-'A']>n/4 ||
			    			dp[i]['T'-'A']>n/4){
		    			break;
		    		}
		    		
		    		for(int j=0; j<s.length()-i;j++){
		    			
		    			if(dp[i]['G'-'A']+dp1[j]['G'-'A']<=n/4 &&
		    			dp[i]['A'-'A']+dp1[j]['A'-'A']<=n/4 &&
		    			dp[i]['C'-'A']+dp1[j]['C'-'A']<=n/4 &&
		    			dp[i]['T'-'A']+dp1[j]['T'-'A']<=n/4){
		    				
		    					if(min>n-(i+j+2)){
		    						min=n-(i+j+2);
		    					
		    				}
		    			}
		    			else{
		    				break;
		    			}
		    			
		    		}
		    	}
		    	
		    	
		    	
		            
		      
		       // System.out.println(min);
		        return min;
	    }
	  
	  
	    
	}

