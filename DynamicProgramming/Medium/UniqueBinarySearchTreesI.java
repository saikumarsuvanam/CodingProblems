package Medium;
// 96 uNique BinarySearchTrees1https://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/
public class UniqueBinarySearchTreesI {
/*
 * Let count[i] be the number of unique binary search trees for i. The number of trees are determined by the number of subtrees which have different root node. For example,

i=0, count[0]=1 //empty tree

i=1, count[1]=1 //one tree

i=2, count[2]=count[0]*count[1] // 0 is root
            + count[1]*count[0] // 1 is root

i=3, count[3]=count[0]*count[2] // 1 is root
            + count[1]*count[1] // 2 is root
            + count[2]*count[0] // 3 is root

i=4, count[4]=count[0]*count[3] // 1 is root
            + count[1]*count[2] // 2 is root
            + count[2]*count[1] // 3 is root
            + count[3]*count[0] // 4 is root
..
..
..

i=n, count[n] = sum(count[0..k]*count[k+1...n]) 0 <= k < n-1

 */
	
//Approach 1 Good Solution
	public int num1Trees(int n) {
		int[] count = new int[n + 1];

		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}

		return count[n];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Approach 2 Top down
	public int numTrees(int n) {

		int dp[][] = new int[n+1 ][n +1];
		return Helper(1, n, dp);

	}

	int Helper(int start, int end, int[][] dp) {
		
		if (start >= end) {
			return 1;
		}
		if (dp[start][end] != 0)
			return dp[start][end];
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum = sum + (Helper(start, i - 1, dp) * Helper(i + 1, end, dp));
		}
		dp[start][end] = sum;
		return sum;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesI u = new UniqueBinarySearchTreesI();
		System.out.println(u.numTrees(22));
		System.out.println(u.num1Trees(22));
	}

}
