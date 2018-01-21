/*Given two integer arrays list1 and list2 and an int target value.
WAP to check if there exists such a sum, where one number taken from list1 
and other from list2 to add up to become the target value. 
Return true if so, else return false.
https://www.careercup.com/question?id=5739394251096064
*/

//0(n) space and 0(n)time complexity
import java.util.*;
public class checking_targetsum_from_two_numbers_each_in_different_lists {

	public static void main(String[] args){
		List<List<Integer>> a=new ArrayList<List<Integer>> ();
		List<Integer> list1 = Arrays.asList(1,2);
		List<Integer> list2 = Arrays.asList(9,8,7,6,5,4,3,2,1,0);
		a.add(list1);
		a.add(list2);
		int target_sum=11;
		HashMap <Integer,Integer> hm=new  HashMap <Integer,Integer>();
		List<Integer> smallsize_list;//to save the space complexity;
		List<Integer> bigsize_list;
		if(a.get(0).size()>a.get(1).size()){
			 smallsize_list=a.get(1);
		     bigsize_list=a.get(0);
		}     
		else{
			smallsize_list=a.get(0);
		    bigsize_list=a.get(1);
		}    
		for(int val:smallsize_list){
				if(!hm.containsKey(val))
				  hm.put(val,1);
			    else hm.put(val,hm.get(val)+1);
		}
		boolean is_possible_targetsum=false;
		for(int val:bigsize_list){
			if(hm.containsKey(target_sum-val)){
				is_possible_targetsum=true;
				System.out.println("oneval is "+val+" other value is "+(target_sum-val));
			}			
		}
		if(!is_possible_targetsum){
			System.out.println("sum not possible");
		}
		
	}
	
}	
