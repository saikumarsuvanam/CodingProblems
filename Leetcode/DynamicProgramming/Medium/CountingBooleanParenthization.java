package Medium;

/*http://yuanhsh.iteye.com/blog/2191935
 * Let us assume that we are given a
boolean expression consisting of symbols ‘true’, ‘false’, ‘and’, ‘or’, and ‘xor’. Find the
number of ways to parenthesize the expression such that it will evaluate to true. For
example, there is only 1 way to parenthesize ‘true and false xor true’ such that it
evaluates to true.
 */

public class CountingBooleanParenthization {

	public int countBoolParenth(char[] symbols, char[] operators) {  
	    int n = symbols.length;  
	    int[][] T = new int[n][n];  
	    int[][] F = new int[n][n];  
	  
	    for (int i = 0; i < n; i++) {  
	        T[i][i] = symbols[i] == 'T' ? 1 : 0;  
	        F[i][i] = symbols[i] == 'F' ? 1 : 0;  
	    }  
	  
	    for (int w = 2; w <= n; w++) { // w: the width of the sliding window, [2, n]  
	        for (int i = 0, j = w-1; j < n; i++, j++) { // i..j: the sliding window, [i, j]  
	            for (int k = i; k < j; k++) { // k: the index of operator to be inserted into symbols  
	                // Store Total[i][k] and Total[k+1][j]  
	                int tik = T[i][k] + F[i][k];  
	                int tkj = T[k + 1][j] + F[k + 1][j];  
	  
	                // Follow the recursive formulas according to the current operator  
	                if (operators[k] == '&') {  
	                    T[i][j] += T[i][k] * T[k + 1][j];  
	                    F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);  
	                }  
	  
	                if (operators[k] == '|') {  
	                    F[i][j] += F[i][k] * F[k + 1][j];  
	                    T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);  
	                }  
	  
	                if (operators[k] == '^') {  
	                    T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];  
	                    F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];  
	                }  
	            }  
	        }  
	    }  
	    return T[0][n - 1];  
	}  

}
