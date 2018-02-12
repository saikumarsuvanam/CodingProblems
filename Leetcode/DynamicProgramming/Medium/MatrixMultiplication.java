package Medium;

public class MatrixMultiplication {
	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int p[], int i, int j) {
		// place parenthesis at different places between first
		// and last matrix, recursively calculate count of
		// multiplications for each parenthesis placement and
		// return the minimum count
		if (i == j)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}

		// Return minimum count
		return min;
	}

	// Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
	static int MatrixChainOrder(int p[]) {

		int dp[][] = new int[p.length][p.length];
		for (int l = 2; l < p.length; l++) {
			for (int i = 1; i < p.length-l+1; i++) {
			    	int j=i+l-1;
			    	dp[i][j] = Integer.MAX_VALUE;
			    	for(int k=i;k<j;k++){
				    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j]);
				}
			}
		}
		return dp[1][p.length - 1];
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 3 };
		int n = arr.length;

		System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
		System.out.println(MatrixChainOrder(arr));

	}
}