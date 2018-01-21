import java.util.ArrayList;

/*
Given a amount and several denominations of coins, find all possible ways 
that amount can be formed? eg amount = 5, denominations = 1,2,3.
Ans- 5 ways
1) 1,1,1,1,1
2) 1,1,1,2 (combinations aren't counted eg 1,2,1,1 etc)
3) 1,1,3
4) 1,2,2
5) 2,3
 * 
 */
public class coins_denominations {
  
	public static void main(String[] args){
		int[] denominations=new int[]{1,2,3};
		int amount=5;
		ArrayList<String> result=new ArrayList<String>();
		count(denominations,amount,0,0,result);
		System.out.println(count);
		//System.out.println(count1(denominations,amount));
	}
	static int count=0;
	static void count(int[] denominations,int amount,int sum,int start,ArrayList<String> result){
		if(sum>amount){
			return;
		}
		 if(sum==amount){
			System.out.println(result);
			count++;
			return;
		}
		
		for(int i=start; i<denominations.length;i++){
			result.add("+"+denominations[i]);
			count(denominations,amount, sum+denominations[i],i,result);
			result.remove(result.size()-1);
			if(sum+denominations[i]>=amount){
				break;
			}
			
			
		}
		
		
		
	}
	
	// Another table solution-DP
	static int count1(int[] coins, int sum) {
	    int size = coins.length;
	    int[] table=new int[sum+1];

	    table[0] = 1;
	    for (int i=0; i<size; i++) {
	        for (int j=coins[i]; j<=sum; j++) {
	            table[j] += table[j-coins[i]];
	        }
	    }

	    return table[sum];
	}
}
