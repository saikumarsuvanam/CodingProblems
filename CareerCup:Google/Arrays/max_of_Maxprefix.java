/*Given an array of n integers. MaxPrefix is defined as count of elements those are greater than the 
element and in the right side of array wrt to the element. 
Write a program to give the max of MaxPrefix Ex. Input 10 -4 6 2 8 9 4 Output is 5
https://www.careercup.com/question?id=5706187292016640
*/
import java.util.*;
public class max_of_Maxprefix {

	public static void main(String[] args){
		int[] input=new int[]{1,2,6,3,8,5,4};
		int min=input[0];
		int maxcount=1;
		int count=1;
		//below is a simple kadane algorithm that i have implemented on my own. time complexity is 0(n)
		for(int i=1; i<input.length;i++){
			if(input[i]<min){
				min=input[i];
				if(maxcount<count){
					maxcount=count;
				}
				count=0;
			}
			count++;
		}
		if(maxcount<count)maxcount=count;
		System.out.println(maxcount-1);
		
	}
	
}
