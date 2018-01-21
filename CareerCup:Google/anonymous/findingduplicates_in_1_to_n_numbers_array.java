/*Write an algorithm that returns any duplicate in an array of integers. 
The algorithm must run in O(n) time and O(1) space. 
(hint: the integers in the array are not greater than the size of the array).*/

//http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class findingduplicates_in_1_to_n_numbers_array {

	
	public static void main(String[] args){
		int[] input={1,2,3,4,5,8,7,3,2,4,6};
	    findduplicates(input);	
		
	}
	public static void findduplicates(int[] input){
		
			if(input == null)
				return;
				
			for(int i = 0; i < input.length; ++i)
			{
				int s = Math.abs(input[i]);
				if(input[s] < 0)	//we have been here before...
				{
					System.out.println(s);
				}
				input[s] = -input[s];
			}
		}
		
		
	}


