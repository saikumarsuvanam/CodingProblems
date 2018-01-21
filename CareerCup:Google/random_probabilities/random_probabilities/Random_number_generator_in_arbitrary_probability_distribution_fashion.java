package random_probabilities;
import java.util.*;

//http://www.geeksforgeeks.org/random-number-generator-in-arbitrary-probability-distribution-
//fashion/
/*Given n numbers, each with some frequency of occurrence. 
 * Return a random number with probability proportional to its frequency of occurrence.

Example:

Let following be the given numbers.
  arr[] = {10, 30, 20, 40}  

Let following be the frequencies of given numbers.
  freq[] = {1, 6, 2, 1}  

The output should be
  10 with probability 1/10
  30 with probability 6/10
  20 with probability 2/10
  40 with probability 1/10 
 */ 
public class Random_number_generator_in_arbitrary_probability_distribution_fashion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] freq={1,2,2};
     int [] arr={10,40,50};
		random_number(arr,freq);
	}

	static int  randomValue(int lower, int higher){
		return (lower+(int)Math.random()*(higher-lower+1));
		}
	
	static void random_number(int[] arr, int[]freq){
		int sum=0;
		int [] ranges=new int[arr.length];
		for(int i=0; i<arr.length;i++){
			sum=sum+freq[i];
			ranges[i]=sum;
		}
		
		
	    int k=randomValue(0, sum);
	    System.out.println(k);
	    int index=findelement(0, arr.length-1, k, ranges);
	   System.out.println(arr[index]);
	    }
		
		
	
	
	
 static int findelement(int l, int r,int j,int[] ranges){
 
 int mid=(l+r)/2;
 if(mid==0){
	 return mid;
 }
 if(ranges[mid]==j||(ranges[mid-1]<j&&ranges[mid+1]>j)){
	 return mid;}
 else if(ranges[mid]<j){
	return findelement(mid+1,r,j,ranges); 
 }
 else {
	 return findelement(l,mid-1,j,ranges);
	 
 }
		 
	 }
	 
	 
 

}
