package Math;
/*https://www.careercup.com/question?id=5717938125406208
https://en.wikipedia.org/wiki/Collatz_conjecture
F (n) = 3n + 1 (if n is odd) or n / 2 (if n is even)
Collapse sequence refers to each number according to this formula
until the sequence becomes equal to 1,
Find the number (which is not greater than 10000), which will have the longest Collapse sequence.
*/



public class collapse_sequence {
   public static void main(String[] args){
	  int max=Integer.MIN_VALUE;
	  int[]dp=new int[100000000];
	  int j=2;
	  for(int i=1;i<10000;i++){
		  if(max<getlongestCollapsesequence( i,dp)){
			  j=i;
			  max=getlongestCollapsesequence(i,dp);
		  }
	  }
	  String s="";
	  
	  System.out.println("longest collapsing sequence length is "+max);
	System.out.println("maximum length  sequence is for number "+j);
	   
   }
   
	
	public static int getlongestCollapsesequence(int n,int[]dp){
        if(dp[n]>0){
        	return dp[n];
        }
        else if(n==1){dp[1]=0;return 0;}
		else if(n%2==0){
			 
			 dp[n]=getlongestCollapsesequence(n/2,dp)+1;
			
	    }
		else{
			
			dp[n]=getlongestCollapsesequence((3*n)+1,dp)+1;
		}
		 return dp[n];
		
	}
	
}
