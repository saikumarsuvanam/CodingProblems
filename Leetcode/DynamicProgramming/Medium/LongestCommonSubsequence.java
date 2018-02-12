package Medium;

import java.util.Arrays;

/*
 * Given two strings: string X of length m [X(1..m)], and string Y of length n [Y(1..n)], find the
longest common subsequence: the longest sequence of characters that appear left-to-right (but not
necessarily in a contiguous block) in both strings. For example, if X = “ABCBDAB” and Y =
“BDCABA”, the LCS(X, Y) = {“BCBA”, “BDAB”, “BCAB”}. We can see there are several
optimal solutions.
 */
public class LongestCommonSubsequence {
//1 d dp
	// For space optimized solution :https://www.geeksforgeeks.org/space-optimized-solution-lcs/
	public int lcs(String x, String y) {
		int [][]dp=new int [2][y.length()+1];
		int bi=0;
		for (int i = 0; i < x.length(); i++) {
            bi=i&1;
			for (int j = 0; j < y.length(); j++) {
			   
				if(x.charAt(i)==y.charAt(j)){
					dp[bi][j+1]=1+dp[1-bi][j];
				}
				else dp[bi][j+1]=Math.max(dp[bi][j],dp[1-bi][j+1]);
               
		}
		}
		return dp[bi][y.length()];


	}
	
	
	// 2d dp
	int lcs( char[] X, char[] Y, int m, int n )
	  {
	    int L[][] = new int[m+1][n+1];
	 
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=m; i++)
	    {
	      for (int j=0; j<=n; j++)
	      {
	        if (i == 0 || j == 0)
	            L[i][j] = 0;
	        else if (X[i-1] == Y[j-1])
	            L[i][j] = L[i-1][j-1] + 1;
	        else
	            L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
	      }
	    }
	    
	    for(int i=1;i<L.length;i++){
	    	System.out.println(Arrays.toString(L[i]));
	    	
	    }
	    recurPrint(L,X,Y,"",m,n);
	    
	    
	  return L[m][n];
	  }
	 //print all the common subsequences using Lcs arrat recursively traverse
	void recurPrint(int l[][], char [] x, char []y,String res,int m, int n){
		if(res.length()==l[x.length][y.length]){
			System.out.println(res);
			return;
		}
		 if(m-1>=0 && n-1 >=0 && x[m-1]==y[n-1]){
			recurPrint(l,x,y,x[m-1]+res,m-1,n-1);
		}
		 else{
		 if(m-1 >=0 && l[m-1][n]==l[m][n]){
				recurPrint(l,x,y,res,m-1,n);
			    }
		 if(n-1 >=0 && l[m][n-1]==l[m][n]){
		  recurPrint(l,x,y,res,m,n-1);}
		
		 }
		 
	}

	public static void main(String[] args) {
		LongestCommonSubsequence l=new LongestCommonSubsequence();
		String x ="ABCBDAB"; String  y ="BDCABA";
		System.out.println(l.lcs(x.toCharArray(),  y.toCharArray(),x.length(),y.length()));
	}
}
