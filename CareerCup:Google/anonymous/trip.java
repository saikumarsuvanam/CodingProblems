package anonymous;

import java.util.HashMap;
import java.util.HashSet;

//https://www.careercup.com/page?pid=google-interview-questions
/*

0

of 0 votes


5 
Answers
You want to spend your next vacation in a foreign country. In the summer you are free for N consecutive day. You have consulted Travel Agency and learned that they are offering a trip to some interesting location in the country every day. For simplicity, each location is identified by a number from 0 to N-1. Trips are described in a non-empty zero indexed array A:for each K(0<=K<N),A[K] is the identifier of a location which is the destination of a trip offered on day K. Travel agency does not have to offer trips to all locations, and can offer more than one trip to some locations. 

You want to go on a trip every day during your vacation. Moreover, you want to visit all locations offered by Travel agency. You may visit the same location more than once, but you want to minimize the duplicate visits. The goal is to find the shortest vacation( a range of consecutive days) that will allow you to visit all the locations offered by travel agency. 

For example, consider array A such that 

A[0] = 7 
A[1] = 3 
A[2] = 7 
A[3] = 3 
A[4] = 1 
A[5] = 3 
A[6] = 4 
A[7] = 1 

Travel agency offers trip to four locations(identified by numbers 1, 3, 4, 7). The shortest vacation starting on day 0 that allows you to visit all these locations ends on day 6(thus is seven days long). However, a shorter vacation of five days(starting from day 2 and ending on day 6) also permits you to visit all locations. On every location shorter than five days, you will have to miss at least one location. 

Write a function:

class solution{ public static int solution(int [] A); }

that, given a non-empty zero-indexed array A consisting of N integers, returns the length of the shortest vacation that allows you to visit all the offered locations. 

For example, given array A shown above, the function should return 5, as explained above. 

Assume that: 

- N is integer within range[1..100,000] 
- each element of array A is an integer within range[0 - N-1] 

Complexity: 

- expected worst case time-complexity o(N). 
- expected worst case space-complexity is o(N), beyond input storage.
 * 
 */
public class trip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [] array=new int[]{7,3,7,3,1,3};
    System.out.println(shortest_days(array));
    
	}

	static int shortest_days(int[] input){
		HashMap<Integer,Integer> Map=new HashMap<Integer,Integer>();
		int start=0;
		int end=0;
		HashSet<Integer> set =new HashSet<Integer>();
		for(int i=0; i<input.length;i++){
		  set.add(input[i]);
		}
		int minstart=0;
		int minend=0;
		int placescovered=set.size();
		int shortestdays=Integer.MAX_VALUE;
		for(int i=0; i<input.length; i++){
			if(Map.containsKey(input[i])&& input[i]==input[start])
			{   
				while(Map.containsKey(input[start])&& (i>Map.get(input[start]))){
				   Map.remove(input[start]);
				 	start=start+1;
				 	
				}
		    }
		        Map.put(input[i],i);
				end=i;
			if(placescovered==Map.size()){	
			 if(shortestdays>end-start+1){
			    shortestdays=end-start+1;
			    minstart=start;
			    minend=end;
			}
			}
		}
		
		System.out.println(minstart+" "+minend);
		return shortestdays;
	}

}
