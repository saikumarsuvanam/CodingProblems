/*https://www.careercup.com/question?id=5717731845341184

Find the maximum of every sub-array of size k in an array of size n.

O(n) solution required.*/

//optimized solution:0(n) time and 0(k) space
/*http://www.ideserve.co.in/learn/maximum-element-from-each-subarray-of-size-k-set-2*/

//i also did minimum for the same problem check below printMinfromEachSubarray method

import java.util.*;
public class maximum_of_every_subarray_of_size_k_in_an_array {

	
	public void printMaxfromEachSubarray(int[] array, int k)
    {
        LinkedList<Integer> list = new LinkedList();
         
        for (int i = 0; i < k; i++)
        {
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() && array[list.getLast()] < array[i])
            {
                list.removeLast();
            }
             
            // add index of current element at the back
            list.addLast(i);
        }
         
        for (int i = k; i < array.length; i++)
        {
            // first element present in the list is the greatest element for the last 'k' sized sub-array
            System.out.println(array[list.getFirst()]);
             
            // now remove all indices of elements from the list which do not belong to current window
            while (!list.isEmpty() && (list.getFirst() < (i-k+1)))
            {
                list.removeFirst();
            }
             
            // now again remove all useless elements present at the front of the list
            // remove all useless elements present at the front of the list
            while (!list.isEmpty() && array[list.getLast()] < array[i])
            {
                list.removeLast();
            }
             
            // and finally insert this new element at the back of the list
            list.add(i);
        }
         
        // now print the largest element from the last sub-array(window)
        System.out.println(array[list.getFirst()]);
    }
	
	
	static void printMinfromEachSubarray(int []array,int k){
		LinkedList l=new LinkedList();
		//first do for k elements and then will add rest elements one by one
		for(int i=0; i<k; i++){
		    while(!l.isEmpty()&&array[(int)l.getLast()]>array[i]){
		        l.removeLast();
			}
		    l.addLast(i);//storing indices	
		}
		System.out.println(array[(int)l.getFirst()]);
		for(int i=k; i<array.length; i++){
			
			while(!l.isEmpty()&&(int)l.getFirst()<i-k+1){
				l.removeFirst();
			}
			while(!l.isEmpty()&&array[(int)l.getLast()]>array[i]){
		        l.removeLast();
			}
			l.add(i);
			System.out.println(array[(int)l.getFirst()]);
		}
		
		
		
		
	}
 
    public static void main(String[] args)
    {
    	maximum_of_every_subarray_of_size_k_in_an_array  solution = new maximum_of_every_subarray_of_size_k_in_an_array ();
 
        int[] array = {9,6,11,8,10,5,14,2,93,1};
        int k = 4;
         
        //System.out.println("Maximum elements from each sub-array of specified size are - ");
        //solution.printMaxfromEachSubarray(array, k);
        System.out.println("Minimum elements from each sub-array of specified size are - ");
        solution.printMinfromEachSubarray(array, k);
    }
}