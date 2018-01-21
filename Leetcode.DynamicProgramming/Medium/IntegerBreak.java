package Medium;
//343. Integer Break https://leetcode.com/problems/integer-break/description/
public class IntegerBreak {
//	Given a number n lets say we have a possible product P = p1 * p2 * … pk. Then we notice what would happen if we could break pi up into two more terms lets say one of the terms is 2 we would get the terms pi-2 and 2 so if 2(pi-2) > pi we would get a bigger product and this happens if pi > 4. since there is one other possible number less then 4 that is not 2 aka 3. Likewise for 3 if we instead breakup the one of the terms into pi-3 and 3 we would get a bigger product if 3*(pi-3) > pi which happens if pi > 4.5.
//
//			Hence we see that all of the terms in the product must be 2’s and 3’s. So we now just need to write n = a3 + b2 such that P = (3^a) * (2^b) is maximized. Hence we should favor more 3’s then 2’s in the product then 2’s if possible.
//
//			So if n = a*3 then the answer will just be 3^a.
//
//			if n = a3 + 2 then the answer will be 2(3^a).
//
//			and if n = a3 + 22 then the answer will be 2 * 2 * 3^a
//
//			The above three cover all cases that n can be written as and the Math.pow() function takes O(log n) time to preform hence that is the running time.

	
	
	
		public class Solution {
			    public int integerBreak(int n) {
			        if(n == 2)
			            return 1;
			        else if(n == 3)
			            return 2;
			        else if(n%3 == 0)
			            return (int)Math.pow(3, n/3);
			        else if(n%3 == 1)
			            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
			        else 
			            return 2 * (int) Math.pow(3, n/3);
			    }
			            
			}
		
		
		//Approach 2 using dp
		public int integerBreak(int n) {
	        int [] dp=new int [n+1];
	        dp[1]=1;
	        for(int i=2;i<=n;i++){
	            for(int j=1;j<=i/2;j++){
	               dp[i]= Math.max(dp[i],Math.max(dp[j]*(i-j),Math.max(dp[i-j]*j,Math.max((i-j)*j,dp[i-j]*dp[j]))));
	            
	                
	            }
	        }
	        return dp[n];
	    }
			


}
