package Medium;

import java.util.HashMap;

// 464. Can I Win https://leetcode.com/problems/can-i-win/description/
public class CanIWin {

	/*
	 * After solving several “Game Playing” questions in leetcode, I find them
	 * to be pretty similar. Most of them can be solved using the top-down DP
	 * approach, which “brute-forcely” simulates every possible state of the
	 * game.
	 * 
	 * The key part for the top-down dp strategy is that we need to avoid
	 * repeatedly solving sub-problems. Instead, we should use some strategy to
	 * “remember” the outcome of sub-problems. Then when we see them again, we
	 * instantly know their result. By doing this, we can always reduce time
	 * complexity from exponential to polynomial. (EDIT: Thanks for @billbirdh
	 * for pointing out the mistake here. For this problem, by applying the
	 * memo, we at most compute for every subproblem once, and there are O(2^n)
	 * subproblems, so the complexity is O(2^n) after memorization. (Without
	 * memo, time complexity should be like O(n!))
	 * 
	 * For this question, the key part is: what is the state of the game?
	 * Intuitively, to uniquely determine the result of any state, we need to
	 * know:
	 * 
	 * The unchosen numbers The remaining desiredTotal to reach A second thought
	 * reveals that 1) and 2) are actually related because we can always get the
	 * 2) by deducting the sum of chosen numbers from original desiredTotal.
	 * 
	 * Then the problem becomes how to describe the state using 1).
	 * 
	 * In my solution, I use a boolean array to denote which numbers have been
	 * chosen, and then a question comes to mind, if we want to use a Hashmap to
	 * remember the outcome of sub-problems, can we just use Map<boolean[],
	 * Boolean> ? Obviously we cannot, because the if we use boolean[] as a key,
	 * the reference to boolean[] won’t reveal the actual content in boolean[].
	 * 
	 * Since in the problem statement, it says maxChoosableInteger will not be
	 * larger than 20, which means the length of our boolean[] array will be
	 * less than 20. Then we can use an Integer to represent this boolean[]
	 * array. How?
	 * 
	 * Say the boolean[] is {false, false, true, true, false}, then we can
	 * transfer it to an Integer with binary representation as 00110. Since
	 * Integer is a perfect choice to be the key of HashMap, then we now can
	 * “memorize” the sub-problems using Map<Integer, Boolean>.
	 */

	// Top Down

	// Approach 1
	// check the below solution class where we have used only the Integer
	// variable instead of used array

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

		// to handle base test cases
		int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
		if (sum < desiredTotal)
			return false;
		if (desiredTotal <= 0)
			return true;

		boolean used[] = new boolean[maxChoosableInteger + 1];
		return helper(maxChoosableInteger, 0, desiredTotal, used);

	}

	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	boolean helper(int maxChoosableInteger, int sum, int desiredTotal, boolean[] used) {
		int key = format(used);
		if (map.containsKey(key))
			return map.get(key);
		boolean res = false;
		for (int i = 1; i <= maxChoosableInteger; i++) {
			// try every unchosen number as next step
			if (!used[i]) {
				if (sum + i >= desiredTotal) {
					return true;
				} else {
					used[i] = true;
					res = helper(maxChoosableInteger, sum + i, desiredTotal, used);
					used[i] = false;
					// check whether this lead to a win (i.e. the other player
					// lose)
					if (!res) {
						map.put(key, true);
						return true;
					}

				}
			}
		}
		map.put(key, false);
		return false;
	}

	// transfer boolean[] to an Integer
	public int format(boolean[] used) {
		int num = 0;
		for (boolean b : used) {
			num <<= 1;
			if (b)
				num |= 1;
		}
		return num;
	}

	// Approach 2 -Best Solution
	public class Solution {
		public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
			if (desiredTotal <= 0)
				return true;
			if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)
				return false;
			return canIWin(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
		}

		private boolean canIWin(int total, int n, int state, HashMap<Integer, Boolean> hashMap) {
			if (hashMap.containsKey(state))
				return hashMap.get(state);
			for (int i = 0; i < n; i++) {
				if ((state & (1 << i)) != 0)
					continue;
				if (total <= i + 1 || !canIWin(total - (i + 1), n, state | (1 << i), hashMap)) {
					hashMap.put(state, true);
					return true;
				}
			}
			hashMap.put(state, false);
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CanIWin c = new CanIWin();
		System.out.println(c.canIWin(10, 1));
	}

}
