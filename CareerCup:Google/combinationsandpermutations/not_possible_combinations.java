import java.util.Scanner;

/* 
 * https://careercup.com/question?id=5751311990521856
count number of combinations which are not possible.
There are 'n' empty slots.
A slot can be filled with 'O', 'E', or 'X'
A combination is possible if
1. 'O' s are placed in odd slot , 'E' a are placed in even slots.
2. 'O' and 'E' alternate among them,
i.e (OXOE) not allowed because between O s there is no 'E'; but (OEXXO) is allowed.
some allowed combinations
OEXXX, XXOEO, OXXEX
For 3 slots, not allowed combinations are
OXX
XXO
XEX
XXX
OXO
Only those combinations are considered in which O s and E s are in their respective odd and even slots.
i.e EEXXX will never be considered because a 'E' is in odd slot
A combination isn't allowed if 'O' is not followed by 'E' or vice versa*/
public class not_possible_combinations {
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        
	        
	         Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            String s1 = in.next();
	                    String[] c =s1.split(" ");
	                    
	            
	            String s2 = in.next();
	    }
}
	 
}
