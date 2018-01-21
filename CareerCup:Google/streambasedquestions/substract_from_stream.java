import java.util.*;
//https://www.careercup.com/question?id=5752226016395264

/*You are given two streams 's_a' and 's_b' of digits. Each stream represents an integer 'a' and 'b' from its less significant digit to the most significant digit. For example, integer 2048 is represented in the stream as 8, 4, 0, 2.

Write a function that subtract two integers 'a - b' and returns the result as a string. You are not allowed to buffer entire 'a' or 'b' into a single string, i.e. you may access only a single digit per stream at time (imagine that 'a' and 'b' are stored in huge files). You may assume that 'a>=b'.

Example:
s_a: 8 4 0 2
s_b: 4 2 0 1

result: '1024'

*/
public class substract_from_stream {
	static int carry=0;
static StringBuilder output=new StringBuilder();
	static void substract(int a,int b){
		if(a-b>0){
		output.insert(0,a-b-carry);
		carry=0;
			
		}
		else if(a-b==0){
		if(carry==0)	
		   output.insert(0, a-b);
		
		else {
			output.insert(0,10+a-carry-b);
			carry=1;
		}
		}
		else{
			output.insert(0, a+10-carry-b);
			carry=1;
		}
}
	public static void main(String[] args){
		
//a is greater than b as given 		
String a="84009";
String b="4201";
int length1=0;
int length2=0;

if(a.length()>b.length()){
	
	for(int i=0; i<a.length()-b.length();i++){
	b=b+"0";
	}
}

while(length1<a.length()&&length2<b.length()){
	int one=a.charAt(length1++)-'0';
	int two=b.charAt(length2++)-'0';
	substract(one,two);

}


System.out.println(output.toString());




}
}