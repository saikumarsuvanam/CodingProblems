import java.util.*;
public class how_many_binary_search_trees_possible {

	public static void main(String[] args) {
		int n=3;
		System.out.println(catalan(1,n));
	}
	static int catalan(int start, int end){
		if(start==end){
			return 1;
		}
		if(start>end){
			return 0;
		}
		int sum=0;
		
		for(int i=start;i<=end;i++){
			
			if(catalan(start,i-1)==0)
			sum=sum+(catalan(i+1,end));
			else if(catalan(i+1,end)==0){
				sum=sum+(catalan(start,i-1));
			}
			else{
				sum=sum+(catalan(start,i-1)*catalan(i+1,end));
			}
		}
		return sum;
	}
	
}
