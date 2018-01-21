package Strings;

import java.util.HashMap;

/*
https://www.careercup.com/question?id=5725584103571456
Given a number "n", find the least number of perfect square numbers sum needed to get "n"

Example:
n=12, return 3 (4 + 4 + 4) = (2^2 + 2^2 + 2^2) NOT (3^2 + 1 + 1 + 1)
n = 6, return 3 (4 + 1 + 1) = (2^2 + 1^2 + 1^2)
*/
public class least_number_of_perfect_squares_sum_to_given_number {

	public static void main(String[] args) {
		int n = 12;

		HashMap<Integer, Integer> map = new<Integer, Integer> HashMap();
		HashMap<Integer, Result> map1 = new<Integer, Result> HashMap();

		String res = "";
		find_least_no(61, 1, map, res);
		System.out.println(min);
		System.out.println(result);
		least_number_of_perfect_squares_sum_to_given_number t = new least_number_of_perfect_squares_sum_to_given_number();
		// Result r=t.find_least_no1( 100, map1,0);
		// System.out.println(r.result);
		// System.out.println(r.level);
	}

	static Integer min = Integer.MAX_VALUE;
	static String result = "";

	static void find_least_no(int n, int level, HashMap map, String res) {
		int x = (int) Math.sqrt(n);
		if (x * x == n) {
			Integer j = x;

			if (min > level) {
				min = level;
				result = res + "+" + j.toString() + "*" + j.toString();
			}
			return;
		} else if (n < 0) {
			return;
		} else if (min < level) {
			return;
		} else {
			for (int i = 1; i <= x; i++) {

				Integer j = i;
				find_least_no(n - (i * i), level + 1, map, res + "+" + j.toString() + "*" + j.toString());
			}
		}

	}

	class Result {

		int level;
		String result;

		public Result(int level, String result) {
			this.level = level;
			this.result = result;

		}
	}

	// very slow method
	Result find_least_no1(int n, HashMap<Integer, Result> map, int number) {
		int x = (int) Math.sqrt(n);
		if (n == 0) {
			Result r = new Result(0, "");
			return r;
		}

		for (int i = 1; i <= x; i++) {
			Result r = find_least_no1(n - i * i, map, i);
			String s = new Integer(i).toString();
			Result r1 = new Result(r.level + 1, r.result + "+" + s + "*" + s);
			if (!map.containsKey(n))
				map.put(n, r1);
			else {
				Result r2 = map.get(n);
				if (r1.level > r2.level) {
					map.put(n, r2);
				} else
					map.put(n, r1);
			}
		}

		return map.get(n);

	}

}
