
import java.util.*;
public class print_combinations_of_a_number_as_different_sums {

	
	
	public static void main(String[] args){
		
		int number=3;
		ArrayList<String> result=new ArrayList<String>();
		String s="";
	printcombinations(s,result,number);
System.out.println(result);	
//System.out.println(count++);	
		
	}
	//static int count=0;
	
	static void printcombinations(String s, ArrayList<String> result,int number){
		
		//count++;
		if(number==0){

		
			result.add(s.substring(0,s.length()-1));
			
			
		}
		
			
	for(int i=1; i<=number; i++){	
		
		
		printcombinations( s+i+"+", result, number-i);
		
		
	}}
		
	
		
	}

