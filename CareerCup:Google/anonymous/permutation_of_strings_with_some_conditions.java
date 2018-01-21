/* Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', 
and 'c', where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's
Example:
findStrings(3) returns 19
since the possible combinations are: aaa,aab,aac,aba,abc,aca,acb,baa,bac,bca,caa,cab,cac,cba,cbc,acc,bcc,cca,ccb
and the invalid combinations are:
abb,bab,bba,bbb,bbc,bcb,cbb,ccc
*/
public class permutation_of_strings_with_some_conditions {
	public static void main(String[] args){
    char c[]=new char[3];
    c[0]='a';
    c[1]='b';
    c[2]='c';
    
    int length=5;//output string length required
    String s="";
	find_permutation(c,"",length,-1);//print all strings possible
	
	System.out.println("No of strings possible "+find_no_of_stringspossible(length));//return no of strings possible
	}
	static int  find_no_of_stringspossible(int length){
		
		/*
		O(n) solution is provided.

		We can divide strings in two types;
		A type which does not contain ‘b’
		and B type which contain ‘b’.
		We can define matrix A and B as follows.

		A[i]: the number of strings of length i in A type.
		B[i]: the number of strings of length i in B type.

		And the answer is A[n] + B[n]

		Because B type strings with lengh i can be generated
		by picking any sting in A type strings with length i-1,
		and put ‘b’ in any position in the string.
		There are total i positions to insert ‘b’,
		thus, following equation holds between A[i] and B[i].

		B[i] = i * A[i-1]

		So, it is enough to compute A[i].
		For considering strings in A, there are three possible
		prefixes which end with ‘a’.
		(because there is no constraint in the substring after ‘a’)

		1. ‘a’ + A type strings with length i - 1
		2. ‘ca’ + A type strings with length i - 2
		3. ‘cca’ + A type strings with length i - 3

		i.e., A[i] = A[i-1] + A[i-2] + A[i-3]
		where A[1] = 2, A[2] = 4, A[3] = 7

		We can compute matrix A iteratively.

		As an example, the number of strings of length 3 is
		A[3] + B[3] = A[3] + 3 * A[2] = 7 + 3*4 = 19.
*/
		     
		int A[] =new int [length+1];

		A[0] = 1; A[1] = 2; A[2] = 4; A[3] = 7;

		if(length<4){
			return A[length]+length*A[length-1];
		}
		        for(int i = 4; i <= length; i++){
		                A[i] = A[i-1] + A[i-2] + A[i-3];
		        }

		        return A[length]+length*A[length-1];
		
		
		
		
		
	}
	
	


	static void find_permutation(char c[],String s,int requiredlength,int bindex){
		if(s.length()==requiredlength){
			System.out.println(s);
			return;
		}
		for(int i=0; i<c.length;i++){
			if(bindex>s.length()-1){bindex=-1;}
			if(c[i]=='b'){ 
			    if(bindex==-1){bindex=s.length(); 
			    find_permutation(c,s+c[i],requiredlength,bindex);
			    }
			   else continue;
			}   
			else if(c[i]=='c') {
				if(s.length()>=2){
				 if(!s.substring(s.length()-2).equals("cc"))
					find_permutation(c,s+c[i],requiredlength,bindex);
				 else continue;}
				
				else find_permutation(c,s+c[i],requiredlength,bindex);
			}
			else find_permutation(c,s+c[i],requiredlength,bindex);
		}
		
		
	}
	
	
}
