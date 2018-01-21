/*https://www.careercup.com/question?id=5637944224251904*/
/*http://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
Find Maximum number possible by doing at-most K swaps

Given a positive integer, find maximum integer possible by doing at-most K swap operations on its digits.

Examples:

Input: M = 254, K = 1
Output: 524

Input: M = 254, K = 2
Output: 542

Input: M = 68543, K = 1 
Output: 86543

Input: M = 7599, K = 2
Output: 9975

Input: M = 76543, K = 1 
Output: 76543

Input: M = 129814999, K = 4
Output: 999984211
*/
public class find_maximum_by_atmost_k_swaps_on_a_number {

	public static void main(String[] args){
	    Integer number=new Integer(7599);
	    String num=number.toString();
	    int k=2;
	   
	   k_swaps(num,k,0);
	   System.out.println(max);
	 
	   
		
	}
	static int max=7599;
	
	//Do DFS and find k-swap combinations
	static void k_swaps(String num, int k,int start){
		if(k==0){
			if(Integer.parseInt(num)>max){
				max=Integer.parseInt(num);
			}
			return;
		}
		for(int i=start; i<num.length();i++){
		  for(int j=i+1; j<num.length();j++){
			if(num.charAt(i)<num.charAt(j)){
				num=swap(i,j,num);
			    k_swaps(num, k-1,i+1);
				num=swap(i,j,num);
			}
		  }
		}
		
	}
	static String swap(int i, int j,String num){
		char[] c=num.toCharArray();
		char temp=c[i];
		c[i]=c[j];
		c[j]=temp;
		StringBuilder s=new StringBuilder();
		for(char c1:c){
			s.append(c1);
		}
		return s.toString();
	}
}
