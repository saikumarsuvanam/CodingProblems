/* 
Implement, recursively, fast exponentiation and give its complexity.
Use any language you want.

List of tests in format {<value>, <power>, <expected result>

	{1000, 0, 1},
	        {3, 1, 3},
	        {0, 0, 1},
	        {0, 1000, 0},
	        {-2, 3, -8},
	        {-2, 4, 16},
	        {-2, -4, 0.0625},
	        {-2, -3, -0.125},
	        {1.01, 1000, 20959.155637813660064},
	        {2, 10, 1024.0},
	        {10, 13, 10000000000000.0}

	Complexity is about ~O(2*log(n))
	Since in worst case we will have following sequence of powers:
	odd -> even -> odd -> even and so on.
	Ex: if power = 15 the function will be called with following value as a power:
	15 -> 14 -> 7 -> 6 -> 3 -> 2 -> 1
	So, amount of sequences (odd -> even) is ~log(n) since every time we dividing by 2; Considering that number of operations in the pair is 2, result will be ~2*log(n) or just O(log(n)).
}
*/
public class fast_exponentiation {
	static double fastExponent(double value, int power) {
	    // For all cases any number at power 0 is 1
	    if (power == 0) {
	      return 1;
	    }
	    // Any number at power 1 is the same number
	    if (power == 1) {
	      return value;
	    }
	    // If value equals to 0, than at any power (except 0, but this case has been checked above) is 0
	    if (value == 0) {
	      return 0;
	    }
	    // Negative power is equals to 1/(value^power)
	    if (power < 0) {
	      return 1 / fastExponent(value, -power);
	    }

	    // Check if power is even number
	    if ((power >> 1) << 1 == power) {
	      double preCalculatedValue = fastExponent(value, power >> 1);
	      return preCalculatedValue * preCalculatedValue;
	    }

	    return value * fastExponent(value, power - 1);
	  }

}	