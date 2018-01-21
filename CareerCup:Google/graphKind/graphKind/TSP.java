package graphKind;

public class TSP {

	static int solveTSP(int m[][]) {
		int dp[][][] = new int[m.length][m.length][m.length];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j][1] = m[i][j];
			}
		}
		for (int k = 2; k < m.length; k++) {
			for (int e = 0; e < m.length; e++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < m.length; j++) {

					min = dp[0][j][k - 1] + dp[j][e][1];
				}
				dp[0][e][k] = min;
			}
		}
		return dp[0][2][m.length-1];

	}

	public static void main(String[] args) {

		int m[][] = new int[][]  { {0, 10, 15, 20},
	        {10, 0, 35, 25},
	        {15, 35, 0, 30},
	        {20, 25, 30, 0}
	    };
		//System.out.println(solveTSP(m));
		TravelingSalesmanHeldKarp k=new TravelingSalesmanHeldKarp();
		System.out.println(k.minCost(m));
		
		

	}
}
