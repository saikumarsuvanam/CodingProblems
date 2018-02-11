package Medium;

import java.util.List;

//120. Triangle https://leetcode.com/problems/triangle/description/
/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
 * 
 */
public class Triangle {
	/*
	 * 
	 * 
	 * Go from bottom to top.
	 * 
	 * We start form the row above the bottom row [size()-2].
	 * 
	 * Each number add the smaller number of two numbers that below it.
	 * 
	 * And finally we get to the top we the smallest sum.
	 * 
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] A = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
			}
		}
		return A[0];
	}

}
