
/*
	 Given a list of coin values, and quantity of each type of coin. Write a
	 program to return the set of all possible sums which can be made using those
	 coins.
	 ex. coins = [10, 50, 100, 500]
	 quantity = [5, 3, 2, 2]
	 sum could be 400 , 300 ,200 , 100
*/
import java.util.*;
public class set_of_all_sum_possible_using_coins {


	 
	
		
		public static void main(String[] args) {
			int coins[] = {10, 50, 100, 500};
			int qty [] = {5,3,2,2};
			
			
			//printSum(coins,qty);
			ArrayList result=new ArrayList();
			printsum(coins,qty,0,0,result);
			
			//printSum(coins,qty);
			
			Integer[] a = Arrays.copyOf(hm.toArray(), hm.toArray().length, Integer[].class);
			Arrays.sort(a);
			
			System.out.println(a.length);
			for(int ax:a){
				
				System.out.println(ax);
			}
			
		}
		
//(Good method:my method)		
static HashSet hm=new HashSet();
static	void	printsum(int coins[],int qty[],int n,int sum,ArrayList result){
			        
	
					if(n==coins.length)
					{   int c=1;
						for(Object j:result){
							if(c==1){ System.out.print(j);
							c++; continue;
						    }
						 System.out.print("+"+j);
						 }
						 System.out.println("="+sum);
						 return;
					}
							
					for(int k=0; k<=qty[n]; k++){
					
					 result.add((k)+"*"+coins[n]);
					  hm.add(sum);
					  
				      printsum(coins,qty,n+1,sum,result);
				      result.remove(result.size()-1);
					 sum=sum+coins[n];
					 
		            }
					
					
}
	
	
	
			
			
		
		
		
		
		
		
		
		
//Another method		
static void printSum(int coins[], int qty[]){
	            
	            int value=1;
	            int sum=0;
	            
	            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	           // map.put(5, 6);
			if(coins == null || qty == null){
				return;
			}
			
			for(int i=0;i<=5;i++){
	                    for(int j=0;j<=3;j++){
	                        for(int k=0;k<=2;k++){
	                            for(int l=0;l<=2;l++){
	                                sum=10*i+50*j+100*k+500*l;
	                                System.out.println(i+" " +j+" "+k+" "+l+" = "+sum);
	                                if(map.containsKey(sum)){
	                                    //System.out.println(map.get(sum));
	                                    map.put(sum,map.get(sum)+1);
	                                }else{
	                                    map.put(sum,value);
	                                }
	                            }
	                        }
	                    }
	                }
			System.out.println(map.size());
	                System.out.println(map);
		}

	}
	

