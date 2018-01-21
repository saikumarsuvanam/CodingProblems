

import java.util.*;
public class permutationsofnumbers {

	
	
	static ArrayList<Integer> nelist=new ArrayList<Integer>();
	static void permute(int n, ArrayList<ArrayList<Integer>> a ){ 
		
		
		if(n<=0){
			
		ArrayList<Integer> c=	nelist;
			a.add(c);
			nelist.clear();
			
			return;
		}
		for(int i=0; i<3; i++){
			
			if(n-i>0){
		
			permute(n-i-1, a);
			nelist.add(i+1);
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>> ();
ArrayList<Integer> b=new ArrayList<Integer>();
	permute(2,a);
	System.out.println(a);
		
		
		
	}
}
