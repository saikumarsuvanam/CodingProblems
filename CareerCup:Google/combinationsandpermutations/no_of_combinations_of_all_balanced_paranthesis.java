/* 
https://www.careercup.com/question?id=5007980722388992
Implement an algorithm to print all possible valid combinations of braces when n pairs of paranthesis are 
given.



1) If we give count as 2, this code should generate only ( )( ). But how does it go for another execution of whole addParen to generate (( )) 
 * 
 */
public class no_of_combinations_of_all_balanced_paranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int n=10;
		produce("",0,n);
	
		
	}
	
	static void produce(String s,int openingBrackets,int closingBrackets){
		if(openingBrackets>closingBrackets){
			return;
		}
		if(openingBrackets==0&&closingBrackets==0){
	
		    System.out.println(s);
			return;
		}
		
		if(openingBrackets==0){
			produce(s+"(",1,closingBrackets-1);
		}
		else{
			produce(s+"(",openingBrackets+1,closingBrackets-1);
			produce(s+")",openingBrackets-1,closingBrackets-1);
		}
	}

}
