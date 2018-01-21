package graphKind;
/*2D matrix with 0s and 1s. Try to find out how many countries in this matrix?

		 For example:
		 [[1,1,1,0]
		 [1,1,0,0]
		 [0,0,0,1]]
		 return 3, because one for 1s, one for 0s, and one for the last one.

		 another example:
		 [[1,1,1,1]
		 [0,0,0,0]
		 [1,0,0,1]]
		 return 4
		 
		 Question:
[1,1,1,0]
[1,1,0,0]
[0,0,0,1]

Look at this like a 2D MAP where the neighbouring country will have different codes.

The 3 countries are

1. Country with area defined by 1, * contains all other countries.
[1,1,1,*]
[1,1,*,*]
[*,*,*,*]

2. Country with area defined by 0, * contains all other countries.
[*,*,*,0]
[*,*,0,0]
[0,0,0,*]

3. Country with area defined by 1, * contains all other countries.
[*,*,*,*]
[*,*,*,*]
[*,*,*,1]

So in total 3 countries.
		 */
public class find_the_connected_components {
  public static void main(String[] args){
	  
	  int[][]matrix=new int[][]{{1,1,1,0},{1,1,0,0},{0,0,0,1}};
	  boolean [][]visited=new boolean [matrix.length][matrix[0].length];
	  int count=0;
	 
	  for(int i=0; i<matrix.length;i++){
		  for(int j=0;j<matrix[0].length;j++){
			  
			  if(visited[i][j]==false){
				  System.out.println(i+" "+j);
				  count++;
			      find_connected_components(matrix,visited,i,j,matrix[i][j]);
			  }
		  }
	  }
	  System.out.println(count);
  }
  
	  
	  static void  find_connected_components(int[][]matrix,boolean visited[][],int row,int col,int country){
		 if(row >=0 && col>=0&&row<matrix.length&&col<matrix[0].length ){
			if(!visited[row][col]&& matrix[row][col]==country){
				visited[row][col]=true;
				  find_connected_components(matrix, visited, row+1, col, country); 
				  find_connected_components(matrix, visited, row, col+1, country); 
				  find_connected_components(matrix, visited, row-1, col, country); 
				  find_connected_components(matrix, visited, row, col-1, country); 
			 }
			else return;
		 }
		 
		 else return;
		  
		  
		  
	  }
	  
  }

	
	
	

