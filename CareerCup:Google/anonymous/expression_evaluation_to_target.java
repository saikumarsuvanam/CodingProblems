package anonymous;

import java.util.HashSet;

/*
 * Add arithmetic operators (plus, minus, times, divide) to make the following
 *  expression true: 3 1 3 6 = 8. You can use any parentheses 
 *  you’d like.
_*/
public class expression_evaluation_to_target {

	public static void main(String[]args){
		char[] operators=new char[]{'+','-','/','*'};
        int [] digits=new int[]{3,1,1,4};
        String expression="3";
        int start=0;
        int target=8;
		produceexpression(operators,digits,1,digits[0],target,expression);
			System.out.println(answer);
		
	}
	static String answer="";
	
	static void produceexpression(char[]operators ,int[] digits,int start,int  value,int target,String expression){
		if(value==target&&start==digits.length )
		{  answer="y";
		
		System.out.println(expression+" "+value);
		
		
	        return;
		
		}
		else if(start==digits.length){
			System.out.println(expression);
			return;
		}
		  
		else {
	
				
		    for(char operator :operators){
		    	String digitex=new Integer(digits[start]).toString();
		    if(operator=='*')
			{    
				produceexpression(operators , digits, start+1, value*digits[start],target,"("+expression+")"+"*"+digitex);
				
			}
			else if(operator=='/'){
				if(digits[start]!=0)
				{produceexpression(operators , digits, start+1, value/digits[start],target,"("+expression+")"+"/"+(digitex));	
				}
		    }
			else if(operator=='-'){
				produceexpression(operators , digits,  start+1,value-digits[start],target,"("+expression+")"+"-"+digitex);
			}
			else if(operator=='+'){
				produceexpression(operators , digits,  start+1,value+digits[start],target,"("+expression+")"+"+"+digitex);
			}
			
		
		    
			}
			return;
		}
		
	}
	
static 	void swap(int start,int index,int[] digits){
       
		int temp=digits[start];
		digits[start]=digits[index];
		digits[index]=temp;
	

		
	}
	
	
	static boolean isOperator(char ch){
		
		if(ch=='*'||ch=='/'||ch=='+'||ch=='-'){
			return true;
		}
		else return false;
	}
}
