import java.util.Arrays;

/*Find the largest and smallest number in a list. 
The list is stored as two sections, one in ascending order and the other in descending order.

input [ 2 3 4 5 6 7 10 9 8 7]
smallest : 2
Largest 10

The minimum is always at either A[0] or A[n - 1]. logn solution to search for the maximum.

The idea is to compare A[i] with A[i+1]. if A[i + 1] > A[i], we are in the rising half of the array. 
If A[i + 1] < A[i], then we are in the falling half. With this knowledge, we can recurse on a 
subproblem half the size, with an O(1) 
check at each recursion. O(logn); code below*/
import java.util.*;
public class find_small_and_largest_in_ascending_and_descending_order_list {
public static void main(String[] args){
	
	int [] a=new int []{2, 3, 4, 5, 6, 7, 12, 13, 8, 7};
	find_small_and_large(a);
}
	
static void find_small_and_large(int[]a){
	
	if(a[0]<a[1])System.out.println("small value is "+ a[0]);
	else System.out.println("small value is "+ a[1]);
	
	int middle=(0+a.length-1)/2;
	//binary search in iterative way
	while(middle<a.length&&middle>=0){
		if(a[middle]>a[middle+1]&& a[middle]>a[middle-1]){System.out.println("largest is "+a[middle]);
		break;}
		else if(a[middle]>a[middle+1]){
			middle=(0+middle)/2;
		}
		else middle=(middle+a.length-1)/2;
	}
}
	
}
