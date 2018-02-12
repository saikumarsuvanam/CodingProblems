package Medium;

public class KnapSackWithRepetetions {

	
	   
	    // Returns the maximum value with knapsack
	    // of W capacity
	    private static int unboundedKnapsack(int W, int n, 
	                                int[] val, int[] wt) {
	         
	        int dp[]=new int [W+1];
	        for(int wght=1;wght<=W;wght++){
	        	dp[wght]=dp[wght-1];
	        	for(int j=0;j<wt.length;j++){
	        		if(wght-wt[j]>=0){
	        			dp[wght]=Math.max(dp[wght],val[j]+dp[wght-wt[j]]);
	        		}
	        		
	        	}
	        }
	        return dp[W];
	    }
	 // Driver program to test above function
	    public static void main(String args[])
	    {
	    	KnapSackWithRepetetions k=new KnapSackWithRepetetions();
	    	 int W = 100;
	         int val[] = {10, 30, 20};
	         int wt[] = {5, 10, 15};
	         int n = val.length;
	    System.out.println(k.unboundedKnapsack(W,  n,val, wt));
	    }
	 
	    
	
}
