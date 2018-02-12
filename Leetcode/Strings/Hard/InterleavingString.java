package Hard;
//https://leetcode.com/problems/interleaving-string/description/

/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
 */
public class InterleavingString {
	
	//Approach #2 Recursion with memoization 
	public class Solution {
	    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
	      if(k==s3.length() && i==s1.length() && j==s2.length()){
	    	  return true;
	      }
	     else if(k>=s3.length() && i>=s1.length() && j>=s2.length()){
	    	return false;
	      }
	      
	      if(i<s1.length()&&j<s2.length() &&memo[i][j]!=-1){
	    	return   memo[i][j]== 1 ? true : false;
	      }
	      boolean ans=false;
	      if(i<s1.length()&&j<s2.length()&&k<s3.length() && s1.charAt(i)==s2.charAt(j)&& s2.charAt(j)==s3.charAt(k)){
	    	  ans= is_Interleave(s1, i+1,  s2,  j,  s3,  k+1, memo)|| is_Interleave(s1,  i,  s2,  j+1,  s3,  k+1, memo);
	     }
	     else if(i<s1.length()&&k<s3.length()&&s1.charAt(i)==s3.charAt(k)){
	    	  ans= is_Interleave(s1, i+1,  s2,  j,  s3,  k+1, memo);
	      }
	     else if(j<s2.length()&&k<s3.length()&&s2.charAt(j)==s3.charAt(k)){
	    	  ans= is_Interleave(s1, i,  s2,  j+1,  s3,  k+1, memo);
	      }
	      else{
	    	  ans= false;
	       }
	      if(i<s1.length()&&j<s2.length()){
	             memo[i][j] = ans ? 1 : 0;}
	      return ans;
	    }
	    public boolean isInterleave(String s1, String s2, String s3) {
	        int memo[][] = new int[s1.length()][s2.length()];
	        for (int i = 0; i < s1.length(); i++) {
	            for (int j = 0; j < s2.length(); j++) {
	                memo[i][j] = -1;
	            }
	        }
	        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
	    }
	}
	
	public static void main(String[] args){
		InterleavingString i=new InterleavingString();
		Solution s=i.new Solution();
		String s1 = "aabcc";
		String s2= "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(s.isInterleave(s1,  s2,  s3));
				
	}

	
}

