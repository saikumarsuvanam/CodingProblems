package DynamicProgramming.Easy;
//746 https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {

	 /*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

	 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
*/
	/*//Let's evaluate f backwards in order. That way, when we are deciding what f[i] will be, we've already figured out f[i+1] and f[i+2].

We can do even better than that. At the i-th step, let f1, f2 be the old value of f[i+1], f[i+2], and update them to be the new values f[i], f[i+1]. We keep these updated as we iterate through i backwards. At the end, we want min(f1, f2).
*/
	
	//time -o(n) space o(n)
	 public int minCostClimbingStairs(int[] cost) {
	        
	        int dp[] =new int [cost.length+1];
	        if(cost.length>0) dp[1]=cost[0];
	        for(int i=1;i<cost.length;i++){
	           dp[i+1]=cost[i]+Math.min(dp[i],dp[i-1]);
	        }
	        return Math.min(dp[cost.length],dp[cost.length-1]);
	    }
	 
	 //LeetCode
	 class Solution {
		    public int minCostClimbingStairs(int[] cost) {
		        int f1 = 0, f2 = 0;
		        for (int i = cost.length - 1; i >= 0; --i) {
		            int f0 = cost[i] + Math.min(f1, f2);
		            f2 = f1;
		            f1 = f0;
		        }
		        return Math.min(f1, f2);
		    }
		}

}
