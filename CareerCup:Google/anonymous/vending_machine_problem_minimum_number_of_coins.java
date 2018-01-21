import java.util.HashMap;
import java.util.Map.Entry;

/*You have a vending machine with some inventory. write a program to help vending machine tender exact 
 * change to the customer.
 * Consider this example - you have to cater 98 cents and you have 50*1 , 20*2, 15*1, 10*1, 1*8... (n*m means you have m instances of n cents)

Greedy answer - 50 * 1 + 20 * 2 + 1 * 8. Total Coins = 11

DP answer - 50*1 + 20*1 + 15*1 + 10*1 + 1*3. Total Coins = 7
 */
public class vending_machine_problem_minimum_number_of_coins {
	
	public static void main(String[] args) {
		int[] coins=new int[]{50,20,15,10,1};
		int[] no_of_coins=new int[]{1,2,1,1,8};
		int sum=98;

		System.out.println(minimum_no_of_coins(sum,coins,no_of_coins));

		System.out.println(count);
		for(Entry e:map.entrySet())
		System.out.println(e.getKey()+" "+e.getValue());
		
	}
	static HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	
    static int count=0;
	static int minimum_no_of_coins(int n,int[] coins,int[] no_of_coins){
		if(map.containsKey(n)){
		return	map.get(n);
		}
		int mincoins=Integer.MAX_VALUE;
		count++;
	    if(n==0){
			return 0;
		}
	    
	    else{ 
	    	for(int i=0; i<coins.length;i++){
	          if(no_of_coins[i]>0&&n-(coins[i])>=0){
    		   int s=n-(coins[i]);
    	       no_of_coins[i]=no_of_coins[i]-1;
    	       int x=1+minimum_no_of_coins(s,coins, no_of_coins);
    	       no_of_coins[i]=no_of_coins[i]+1;
    	       if(mincoins>x){
    	    	   mincoins=x;
    	       }
    	       } 
    	   
    	   
       }
	    	int p;
	    	if(mincoins!=Integer.MAX_VALUE)
	    	{    p= mincoins;
	    		if(!map.containsKey(n)){
	    	       map.put(n, p);
		    
	    	 }
	    	}	
	    	else{
	    	p= mincoins-1;
	    	}
	    
	    return p;
	    }
       

		
	
}
}
