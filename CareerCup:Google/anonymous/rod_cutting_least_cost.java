import java.util.HashMap;

/*You are given a log of wood of length `n’. There are `m’ markings on the log. 
The log must be cut at each of the marking. The cost of cutting is equal to the length of the 
log that is being cut. Given such a log, determine the least cost of cutting.*/
public class rod_cutting_least_cost {

	public static void main(String[] args){
		int N=9;//length of rod
		//here in markings first=0;
		//last=10 are add just as marking to be useful in programming
		int [] markings=new int[]{0,2,3,5,10};
		
		int cost=0;
	
	least_cost_cutting( N, 0,markings.length-1,markings,cost);
	System.out.println(mincost);
	}
	
	
	
	static int  mincost=Integer.MAX_VALUE;
	static void least_cost_cutting(int N, int start,int end,int [] markings,int cost){
	
	
	if(end-start==1){
		if(mincost>cost){
			mincost=cost;
		}
				return;
	}
	
	
	else {
	for(int i=start+1; i<=end-1;i++){
	
	if(markings[end]-markings[i]==markings[i]-markings[start]){
		cost=cost+markings[end]-markings[i];
		least_cost_cutting(N,start,i,markings,cost);
		least_cost_cutting(N,i,end,markings,cost);
		
	}
		
	else if(markings[end]-markings[i] <markings[i]-markings[start]){
		   cost=cost+markings[end]-markings[i];
		  end=i;
		  least_cost_cutting(N,start,end,markings,cost);
		 
	   }
	   else {cost=cost+markings[i+1]-markings[start];
	   start=i;
	   least_cost_cutting(N,start,end,markings,cost);
	   }
		
	
			
			
	}
	}
	}
}
