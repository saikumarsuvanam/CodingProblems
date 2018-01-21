import java.util.*;
//https://www.careercup.com/question?id=5768048830054400
/*Write a function that takes as input an array of integers A, and two integers low and high.

Your function has to output pairs of indices: {(i,j), ...}

Where each pair of indices denotes that the subarray of A[i...j] has a sum in the range low <= sum <= high.

Apparently there are algorithms better than O(N^2).
*/


//Solution is 0(nlogn) and space is o(n)
//Solution:http://cpluspluslearning-petert.blogspot.co.uk/2016/08/data-structure-and-algorithm-finx-sub.html
//here assuming given all are positive numbers
public class sub_array_sum_in_given_range_return_the_index_pairs {

	class sumsubarray{
		int sum;
		int index;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sub_array_sum_in_given_range_return_the_index_pairs t=new 	sub_array_sum_in_given_range_return_the_index_pairs();	
    int[] input=new int[]{1,2,3,2};
    int low=2;
    int high=4;
    ArrayList<sumsubarray> result=new ArrayList<sumsubarray>();
    t.find_index_pairs_in_array(input, low,high);
	
	}
   static int   find_index_pairs_in_array(int[] input, int low,int high){
		int start_index=-1;
		int end_index=start_index;
		int sum=0;
		ArrayList<sumsubarray> sumarraylist=new ArrayList<sumsubarray>(); 
		for(int i=0;i<input.length; i++){
			sum=sum+input[i];
		    sumsubarray s=new sumsubarray();
		    s.sum=sum;
		    s.index=i;
		    sumarraylist.add(s);
		}    
		for(int i=0; i<sumarraylist.size(); i++){
			
		    if(input[i]>=low && input[i]<=high){
			  System.out.println(i+" ,"+i);
		      }
		     int index=find(low,sumarraylist,0,input.length-1);
			if(sumarraylist.get(i).sum>=low && sumarraylist.get(i).sum<=high){
				print(low,high,sumarraylist,i);
			}
			low=low+input[i];
			high=high+input[i];
			
			
		}
		
	int 	find(int low,ArrayList<sumsubarray> sumlist,int l,int h ){
			
			int mid=(l+h)/2;
			if(sumlist.get(mid).sum==low) return mid;
			else if(sumlist.get(mid).sum<low) {
					if(sumlist.get(mid+1).sum>=low){
						return (mid+1);
					}
					else return find (low,sumlist,mid+1,h);
			}
					
			else {
				if()
				find(low,sumlist,low,mid);
			}
			
			
			
			
		}
		
		while(end_index<input.length && start_index<input.length){
	        
			if(sum>=low&& sum==high){
			System.out.println((start_index+1 )+","+(end_index));	
			sum=sum-input[++start_index];}
			if(sum>=low && sum<high){
				end_index++;
				if(end_index<input.length)
				sum=sum+input[end_index];
			}
			if(sum>high){	
				int x;
				x=sum-input[start_index+1];
				
				if(x>=low && x<=high)
				{
					System.out.println((start_index+1 )+","+(end_index));	
				}
				if(sum-input[end_index]<=high && sum-input[end_index]>=low){
					
					System.out.println((start_index+1 )+","+(end_index-1));	
					
				}
				sum=sum-input[++start_index];
				
			}
			if(sum<low){
				
				end_index++;
				if(end_index<input.length && start_index<input.length){
				sum=sum+input[end_index];
				}
			}
			
			

		
	}
		return result;

}
}