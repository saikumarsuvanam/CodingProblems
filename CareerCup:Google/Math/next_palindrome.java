package Math;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;
/*Steps: 1) take the mirror first like 9874 t0 9889 or 987 to 989
2) if that mirror is greater than the given value, we will return that mirrored value.
3)else we will increase the middle element.
4)for even numbers also like for 9897, will increment value 8 at index 1.
5)for odd numbers it is like exact middle for 989 will increase value 8 at index 1.
6) now if middle is 9 then we propogate the carry to the left.
0(logn)*/
public class next_palindrome {

	/**
	 * Finds the Next Palindrome.
	 */

	 
	  /**
	   * Brute Force method.
	   * Keeps incrementing by one until a palindrome is found.
	   * @param s
	   * @return the next palindrome
	   */
	  public static String bruteForce(String s){
	    BigInteger i = new BigInteger(s) ;
	    while(true){
	      i = i.add(BigInteger.ONE);
	      final String result = i.toString();
	      if(isPalindrome(result)){
	        return result;
	      }
	    }
	  }
	 
	  /**
	   * Mirrors a string around the centre.
	   * Example: abc -> aba and abcd -> abba
	   * @param s
	   * @return mirrored string
	   */
	  public static String mirror(String s) {
	    final char[] arr = s.toCharArray();
	    int midpoint = arr.length / 2;
	    int i = arr.length % 2 == 0 ? midpoint : midpoint + 1;
	    while (i < arr.length) {
	      arr[i] = arr[midpoint - 1];
	      i++;
	      midpoint--;
	    }
	    return new String(arr);
	  }
	 
	  /**
	   * Increments the middle digit.
	   * Example: 12345 -> 12445 and 1234 -> 1334
	   * 9s get incremented to 0 and carried over.
	   * Example: 12945 -> 13045
	   * @param s
	   * @return incremented string
	   */
	  public static String incrementFromMiddle(String s) {
	 
	    final char[] arr = s.toCharArray();
	    final int midpoint = arr.length / 2;
	    int currPoint = arr.length % 2 == 0 ? midpoint - 1 : midpoint;
	    boolean found = false;
	 
	    while (currPoint >= 0 && !found) {
	      char c = arr[currPoint];
	      char inc;
	      if (c == '9') {
	        inc = '0';
	      }
	      else {
	        inc = (char) (c + 1);
	        found = true;
	      }
	      arr[currPoint] = inc;
	      if (!found) {
	        currPoint--;
	      }
	    }
	 
	    if (!found) {
	      // we have fallen off the start of the string
	      // example 999 has become 009. Add a one on to give: 1009
	      final char[] newarr = new char[arr.length + 1];
	      newarr[0] = '1';
	      System.arraycopy(arr, 0, newarr, 1, arr.length);
	      return new String(newarr);
	    }
	    else {
	      return new String(arr);
	    }
	  }
	 
	 
	 
	  /**
	   * Next Palindrome using the mirroring approach.
	   * @param s
	   * @return
	   */
	  public static String getNextPalindrome(String s) {
	    String mirrored = mirror(s);
	 
	    //the mirror might be smaller than original, so increment it and try again.
	    if (compare(mirrored, s) <= 0) {
	      mirrored = mirror(incrementFromMiddle(s));
	    }
	    return mirrored;
	  }
	 
	  /**
	   * @param s
	   * @return true if the specified string is a palindrome.
	   */
	  private static boolean isPalindrome(String s) {
	    //compare first and last chars, and so on...
	    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
	      if (s.charAt(i) != s.charAt(j)) {
	        return false;
	      }
	    }
	    return true;
	  }
	 
	  /**
	   * Compares two numerical mirrored strings.
	   * Assumes they have the same length.
	   * Only compares the second half of the strings.
	   * @param s
	   * @param t
	   * @return -1, 0 or 1 if s<t, s==t or s>t
	   */
	  private static int compare(String s, String t){
	    //only check second half
	    final int midpoint = s.length() / 2;
	    int i = s.length() % 2 == 0 ? midpoint : midpoint + 1;
	    for (; i < s.length(); i++) {
	      if(s.charAt(i) < t.charAt(i)){
	        return -1 ;
	      }
	      else if (s.charAt(i) > t.charAt(i)){
	        return 1;
	      }
	    }
	    return 0;
	  }
	 
	  /**
	   * The main method.
	   *
	   * @param args
	   */
	  public static void main(String[] args) {
	    // fast output as there is no flush on \n
	
	        System.out.println(getNextPalindrome("124532"));
	      }
	    
	   
	  }
	

