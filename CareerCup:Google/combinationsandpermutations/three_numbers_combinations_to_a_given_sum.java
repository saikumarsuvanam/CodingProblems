import java.util.ArrayList;

/*

Suppose you have a million integer numbers.
Return all possible values of a,b and c such that
a+b+c<=d.
d will be provided to you.
ex: if the numbers are 1,2,3,4,5,6,7
and d=7
[1,2,3]
[1,2,4]

[1,2,3] will be same as [1,3,2] and [3,2,1]...

follow up:

Return all such parts that satisfy the above condition if d is not provided.*/
public class three_numbers_combinations_to_a_given_sum {

	public static void main(String[] args) {
	ArrayList<Integer> res=	new ArrayList<Integer>();
		find(0,999,1,3,res);
		System.out.println(count);
	}
	static int count=0;
	static void find(int sum,int d,int start,int numbers,ArrayList<Integer> res){
		
		if(sum>d){
			return;
		}
		if(sum==d&numbers==0){
			count++;
		System.out.println(res);
			return;}
	    if(numbers<0){
		   return;
	    }
		
		for(int i=start; i<=1000;i++){
			 res.add(i);
			 find(sum+i,d,i+1,numbers-1,res);
			 res.remove(res.size()-1);
			
		}
	
	
		
	}
}
