package Arrays;
//https://www.careercup.com/question?id=5186461135536128
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/*Given an unsorted array of natural numbers. Where numbers repeat in array. Out put numbers in the order of frequency. Where number of out put is passed as parameter.
For Ex:
Array -> [0, 0, 100, 3, 5, 4, 6, 4, 2, 100, 2, 100]
n -> 2
Out put -> [100, 0] or [100, 2]
Since 100 is repeated 3 times and 0, 2 is repeated 2 times, out put up to 2 most 
frequent elements, program should out put either 100, 0 or 100, 2
*/

//use hashmap and count frequency://0(n) time and o(n) space
//use frequency count to sort //0(max frequneccy) space and 0(maxfreq) time
//total 0(n)+o(max freq)//max fre at worst is o(n)
public class output_numbers_in_order_of_frequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{0, 0, 100, 3, 5, 4, 6, 4, 2, 100, 2, 100};
		output_numbers_in_order_of_frequency t=new output_numbers_in_order_of_frequency();
		t.output_numbers_freq(arr);
		

	}
	class element{
		int value;
		int freq;
		element(int val,int freq){
			this.value=val;
			this.freq=freq;
		}
	
		public String toString(){
			return this.value+ " frequency is "+this.freq;
		}
	}
	 void output_numbers_freq(int []arr){
		HashMap<Integer,Integer > hm=new HashMap<Integer,Integer>();
		for(int i=0; i<arr.length;i++){
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i], 1);
			}
			else {
				int count= hm.get(arr[i]);
				count++;
				hm.put(arr[i],count);
			}
		}
		ArrayList<element> elements=new ArrayList<element>();
	for(Map.Entry<Integer,Integer> pair: hm.entrySet()){
		//System.out.println(pair.getKey()+" "+pair.getValue());
		  elements.add(new element(pair.getKey(),pair.getValue()));
    }
	//use counting sort //now
	//find max freq and intialiaze counting array to that size
	int max=Integer.MIN_VALUE;
	for(element e:elements){
		    if(max<e.freq){
		    	max=e.freq;
		    }
	}
	ArrayList<LinkedList<element>> count=new ArrayList<LinkedList<element>>(max+1);
    for(int i=0; i<max+1;i++){
    	count.add(new LinkedList<element>());
    }
	//intialize counting array
	
	for(element e:elements){
		count.get(e.freq).add(e);
	}
	
	  
	for(int i=1; i<count.size();i++){
	   System.out.println(count.get(i));	
    }
	
}
}