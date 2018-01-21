package Medium;

//361 Bomb Enemy
//https://discuss.leetcode.com/topic/48565/short-o-mn-time-o-n-space-solution/42?page=3
public class BombEnemy {
	// Walk through the matrix. At the start of each non-wall-streak (row-wise
	// or column-wise), count the number of hits in that streak and remember it.
	// O(mn) time, O(n) space.
	// Short O(mn) time O(n) space solution
	public int maxKilledEnemies(char[][] grid) {
		int result = 0;
		int rows = grid.length;
		int cols = (rows > 0 ? grid[0].length : 0);
		int[] colhits = new int[cols];
		int rowhits = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				// Travers entire row
				if (col == 0 || grid[row][col - 1] == 'W') {
					rowhits = 0; // reset
					for (int i = col; i < cols && grid[row][i] != 'W'; i++)
						if (grid[row][i] == 'E')
							rowhits++;
				}

				// Traverse entire col
				if (row == 0 || grid[row - 1][col] == 'W') {
					colhits[col] = 0; // reset
					for (int i = row; i < rows && grid[i][col] != 'W'; i++)
						if (grid[i][col] == 'E')
							colhits[col]++;
				}
				if (grid[row][col] == '0') // can place bomb only in Empty space
					result = Math.max(result, rowhits + colhits[col]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
