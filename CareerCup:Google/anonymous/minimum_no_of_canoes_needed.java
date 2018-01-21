import java.util.*;
import java.util.Map.Entry;
//https://www.careercup.com/question?id=6303093824159744
//If a canoe can hold 2 kids and a max weight of 150 lbs, 
//write a function that returns the minimum number of canoes needed, 
//given a list of kids and their weights.
public class minimum_no_of_canoes_needed {
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] kids=new Integer[]{100, 145};//weights
		ArrayList<Integer> input= new ArrayList<Integer>(Arrays.asList(kids));
       System.out.println("minimum no canoes needed"+" "+find_canoes_min(kids));//find minimum no of canoes
           
  
       find_min_canoes(input,-1, -1, 0);//2nd method
       System.out.println(mini);//2nd method answer
  
       
     
	}
	//using sorting.time complexity:0(nlogn)
static int 	find_canoes_min(Integer[] input){
		Arrays.sort(input);
		int first=0;
		int last=input.length-1;
		int canoes=0;
		
		while(first<last){
			
			if(input[first]+input[last]<=150){ //max weight given 150
				canoes++;
				first++;
				last--;
			}
			else if(input[last]<=150) {
				canoes++;
				last--;
			}
		}
		return canoes+1;
		
	}


//2nd method using recursion basically checking all the combinations but more complexity than sorting


static int mini=Integer.MAX_VALUE;

static void find_min_canoes(ArrayList<Integer>input,int i,int j,int canoes){
	
	ArrayList input1= (ArrayList) input.clone();
	Integer weight1=0;
	Integer weight2=0;
	if(i>=0&&j>=0){
	if(i==j){
		if(input.get(i)<=150){
			canoes++;}
		
	
	 weight1=(Integer)input1.remove(i);
	
	}
else if(input.get(i)+input.get(j)<=150){
			canoes++;
			
	weight1=		(Integer)input1.remove(i);	
		weight2=(Integer)	input1.remove(j-1);
		}
else if(input.get(i)+input.get(j)>150&& input.get(i)>150 && input.get(j)>150){
	weight1=(Integer)input1.remove(i);
	weight2=(Integer)input1.remove(j-1);
	
	
}
else {
	canoes=canoes+2;
	weight1=(Integer)input1.remove(i);
	weight2=(Integer)	input1.remove(j-1);
}
	}
	if(input1.size()==0){
		
	mini=	Math.min(canoes, mini);
	}
		
	for(int k=0;k<input1.size();k++){
		for(int l=k;l<input1.size();l++){
			
			 find_min_canoes(input1,k,l,canoes);}
	}
	
}
	
}
	



