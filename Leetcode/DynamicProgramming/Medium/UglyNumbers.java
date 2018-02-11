package Medium;

import java.util.TreeSet;

/*264. Ugly Number II https://leetcode.com/problems/ugly-number-ii/description/
 *  Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 
 */
public class UglyNumbers {

	/*
	 * We have an array k of first n ugly number. We only know, at the
	 * beginning, the first one, which is 1. Then
	 * 
	 * k[1] = min( k[0]x2, k[0]x3, k[0]x5). The answer is k[0]x2. So we move 2’s
	 * pointer to 1. Then we test:
	 * 
	 * k[2] = min( k[1]x2, k[0]x3, k[0]x5). And so on. Be careful about the
	 * cases such as 6, in which we need to forward both pointers of 2 and 3.
	 * 
	 * x here is multiplication.
	 */

	// good Solution with better time complexity
	public class Solution {
		public int nthUglyNumber(int n) {
			int[] ugly = new int[n];
			ugly[0] = 1;
			int index2 = 0, index3 = 0, index5 = 0;
			int factor2 = 2, factor3 = 3, factor5 = 5;
			for (int i = 1; i < n; i++) {
				int min = Math.min(Math.min(factor2, factor3), factor5);
				ugly[i] = min;
				if (factor2 == min)
					factor2 = 2 * ugly[++index2];
				if (factor3 == min)
					factor3 = 3 * ugly[++index3];
				if (factor5 == min)
					factor5 = 5 * ugly[++index5];
			}
			return ugly[n - 1];
		}
	}

	public int nthUglyNumber(int n) {
		int[] a = new int[] { 2, 3, 5 };
		int count = 1;
		TreeSet<Long> set = new TreeSet<Long>();
		set.add((long) 2);
		set.add((long) 3);
		set.add((long) 5);
		long nthvalue = 1;
		while (count < n) {
			nthvalue = set.pollFirst();
			set.add(nthvalue * 2);
			set.add(nthvalue * 3);
			set.add(nthvalue * 5);
			count++;

		}
		System.out.println(set);
		return (int) nthvalue;

	}

	public static void main(String[] args) {
		UglyNumbers u = new UglyNumbers();
		System.out.println(430467210 * 5);
		System.out.println(u.nthUglyNumber(1600));
	}

}
