package random_probabilities;
import java.util.Random;

/*Random generate a NxN matrix with only four types of element: 1,2,3,4.
However, no column or row can have same type of element appears 3 times or above continuously (three same type of elements are connected)

ex:

valid:
1 2 1 1
3 1 4 2
1 2 4 2
3 1 2 3

invalid because the first column has element 1 appears three times and all 1s are connected to each other :

1 2 1 3
1 3 4 2
1 2 4 4
2 3 2 2
- wtcupup2017 December 30, 2016 in United States | Report Duplicate | Flag 
 * 
 * 
 * 
 */
public class randomnumbers_filling_matrix_with_condition {
	public static void main(String[] args) {
    	System.out.println();
    	System.out.println("Generating matrix");
    	int [][] matrix = generateMatrix(4);
    	
    	for(int row = 0; row < matrix.length; ++row){
    		for(int col = 0; col < matrix.length; ++col){
    			System.out.print(" " + matrix[row][col]);
    		}
    		System.out.println();
    	}    	
}

public static int [][] generateMatrix(final int N){

    	int [][] result = new int[N][N];
    	
    	for(int row = 0; row < N; ++row){
    		for(int col = 0; col < N; ++col){
    			setValidNum(row, col, result);		
    		}
    	}
    	
    	return result;

}

    //idea is to fill the rows and cols up in ascending order so we only need
    //to look backwards for problems, can have at most 2 invalid nums
    private static void setValidNum(int row, int col, int [][] arr){    	
    	
    	int invalidNum1 = 0;
    	int invalidNum2 = 0;
    	
    	if(col-2 >= 0 ){ 
                if(arr[row][col-1] == arr[row][col-2]){
                          invalidNum1 = arr[row][col-1];
                } 
        }

    	if(row-2 >= 0){ 
                if(arr[row-1][col] == arr[row-2][col]){
                       invalidNum2 = arr[row-1][col];         
                } 
        }       	
    	    	
    	Random rand = new Random();
    	int result = rand.nextInt(3) ;  
    	System.out.println(result);
    	
    	while(result == invalidNum1 || result == invalidNum2){
    		result = rand.nextInt(3) ;
    		
    	}    	    	
    	
    	arr[row][col] = result;
   }
	
	
	
}
