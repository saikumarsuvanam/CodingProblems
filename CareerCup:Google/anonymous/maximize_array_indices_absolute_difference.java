/*Given an Array A with n elements. Pick maximum number of elements from given array following the rule:
1. We cannot pick A[i] and A[j] if absolute value of (A[i] - A[j]) > absolute value of (i - j)

Example: {13,5,4}
Ans: 2
Pick 5 and 4.*/

//am trying only brute force-o(nsquare) didnot find better solution 
import java.util.*;
public class maximize_array_indices_absolute_difference {

	public static void main(String[] args){
		int array []=new int []{13,5,4};
		System.out.println(maximizedifference(array));
		
		
	}
static int	maximizedifference(int[]nums){
		
		
	   
	    
	    for(int i=0; i<nums.length; i++) {
	      for(int j=i+1; j<nums.length; j++) {
	        if(Math.abs(nums[i] - nums[j]) <= Math.abs(i-j)) {
	          return (int) Math.abs(i-j)+1;
	          
	        
	        }
	       
	      }
	    
	    }
	    return -1;
	  }
	
}
