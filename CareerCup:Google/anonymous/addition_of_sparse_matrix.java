package anonymous;
/*https://www.careercup.com/question?id=5737689417515008
Given a sparse matrix, implement below two methods:
void set(int row, int col, int val) /*Update value at given row and col*/
//int sum(int row, int col) give sum from top left corner to given row, col sub-matrix
//*/
//http://stackoverflow.com/questions/2277749/calculate-the-sum-of-elements-in-a-matrix-efficiently

//for sparse matrix we can use a hashmap to represent the matrix
import java.util.*;
public class addition_of_sparse_matrix{
	  private final Map<Integer, Map<Integer, Integer>> map;
	  private final int N;
	    private final int M;
		private int[][] columnSum;
	  addition_of_sparse_matrix(int rows, int columns) {
	        N =columns;
	        M = rows;
	        map = new HashMap<>();
	        
			this.columnSum = new int[rows][columns];
	    }

	    // assume 0 index
	  void set(int row, int col, int val) {
	        if (row < 0 || row >= N || col < 0 || col >= M) {
	            throw new IllegalArgumentException();
	        }
	        Map<Integer, Integer> rowMap = map.get(row);
	        
	        if (rowMap == null) {
	            rowMap = new HashMap<>();
	            map.put(row, rowMap);
	            rowMap.put(col, val);
	            columnSum[row][col]=val;
	        }
	        else if(rowMap.get(col)==null) {
	        	
					rowMap.put(col, val);
					if(row==0)
						columnSum[row][col]=val;	
					if(row>0)
					 columnSum[row][col]=columnSum[row-1][col]+val;
	        }
	        else {
	        int difference=val-map.get(row).get(col);
	        rowMap.put(col, val);
	        for(int startrow=row;startrow<M; startrow++ )
	        columnSum[startrow][col]=columnSum[startrow][col]+difference;
	        }
	 }
	
	

	public int sum(int row, int col){
		int result = 0;
		if(row < M && col < N){
			for(int i = 0; i <= col; i++){
				result += columnSum[row][i];
			}
		}
		return result;
	}

	public static void main(String[] args){
		addition_of_sparse_matrix a=new addition_of_sparse_matrix(3,3);
		a.set(0, 0, 0);
		a.set(0, 1, 1);
		a.set(0, 2, 4);
		a.set(1, 0, 2);
		a.set(1, 1, 3);
		a.set(1, 2, 2);
		a.set(2, 0, 1);
		a.set(2, 1, 2);
		a.set(2, 2, 2);
		
		System.out.println(a.sum(1,2));
		System.out.println("after updating row=1 and col=2 in originalmatrix as matrix[1][2]=4");
		a.set(1,2,4);
		System.out.println(a.sum(1,2));
		
	}
	
	
}