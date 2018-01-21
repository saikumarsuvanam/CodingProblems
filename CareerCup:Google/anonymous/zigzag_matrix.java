
public class zigzag_matrix {

	
	public static void main(String[] args) {
        int[][] test1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printZigZag(test1);

        System.out.println();   // new line for a new test

        int[][] test2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},{17,18,19,20},{21,22,23,24}};
        int [] t=printZigZag(test2);
        for(int i=0; i<t.length; i++){
    	     System.out.println(t[i]);
    	   }
        }

	static int [] printZigZag(int [][] matrix){
		
		
		
		 int s=0;
		    int row=matrix.length;
		    int col=matrix[0].length;
		     int []result=new int[row*col];
		    for(int n=0; n<row+col-1; n++){
		        
		      int  j=0;
		    int    i=0;
		        
		if(n%2==1){
		   if(n>=col){
		        j=col-1;
		        i=n-(col-1);
		        
		    }
	       else{
		        j=j+n;
		        
		    }
		    while(j>-1&& i<row){

		    result[s++]=matrix[i][j];
		    
		    j--;
		    i++;
		    
		        }
		    
		}
		        
		        
		        else{
		            if(n>=row){
		                i=row-1;
		                j=n-(row-1);
		                
		            }
		        else i=i+n;
		        while(i>-1&& j<col){
		        result[s++]=matrix[i][j];
		        i--;
		        j++;
		            
		        }
		            
		        }
		    
		}        
		            
		            
		    return result;  
		        
		        
		    }
		
	/* ANOTHER SOLUTION 
	 * 
	 * public static void printZigZag(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        // upper left triangle (including minor diagonal)
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=Math.min(M, i); j++) {
                int next = matrix[i - j][j-1];
                System.out.print(next + " ");
            }
        }
        
        // lower right triangle (excluding minor diagonal)
        for(int i=1; i<M; i++) {
            for(int j=i; j<M; j++) {
                int next = matrix[N + i - j - 1][j];
                System.out.print(next + " ");
            }
        }*/
    }
		
	
	

