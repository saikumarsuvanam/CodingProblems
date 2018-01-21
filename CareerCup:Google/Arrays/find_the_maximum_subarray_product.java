import java.util.*;
public class find_the_maximum_subarray_product {

	public static void main(String[] args){
		
        int [] arr=new int[]{1,2,0,8,2,0,6,-3,0,-9,0};
		
	System.out.println(	find_max_product(arr));
	
	}
	
	static int find_max_product(int []arr){
		
	int 	start=0;
	int 	end=0;
	int prod=1;
	int maxstart=0;
	int max=Integer.MIN_VALUE;
		for(int i=0; i<arr.length;i++){
			prod=prod*arr[i];
			if(max<prod){
		     max=prod;
		     maxstart=start;
		     end=i;
		   }
		   if(arr[i]==0){
			prod=1;
			start=i+1;
		   }
		}
		System.out.println("start index of subarray is" +maxstart);
		System.out.println("end index of subarray is "+end);
		
		return max;
		
	}
}
