package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

//368. Largest Divisible Subset https://leetcode.com/problems/largest-divisible-subset/description/
/*
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]
 */
public class LargestDivisibleSubset {

	/*
	 * Steps for BottomUp: Idea is to first sort the array. Whenever you want to
	 * add a new element j+1 to a largest subset from (o,j) ,you can check only
	 * the whether big number in the subset divides the newly added number. 1.
	 * Sort 2. Find the length of longest subset 3. Record the largest element
	 * of it. 4. Do a loop from the largest element to nums[0], add every
	 * element belongs to the longest subset.
	 */
	class BottomUp {

		public List<Integer> largestDivisibleSubset(int[] nums) {

			int n = nums.length;
			int[] count = new int[n];
			int[] pre = new int[n];
			Arrays.sort(nums);
			int max = 0, index = -1;
			for (int i = 0; i < n; i++) {
				count[i] = 1;
				pre[i] = -1;
				for (int j = i - 1; j >= 0; j--) {
					if (nums[i] % nums[j] == 0) {
						if (1 + count[j] > count[i]) {
							count[i] = count[j] + 1;
							pre[i] = j;
						}
					}
				}
				if (count[i] > max) {
					max = count[i];
					index = i;
				}
			}
			List<Integer> res = new ArrayList<>();
			while (index != -1) {
				res.add(nums[index]);
				index = pre[index];
			}
			return res;
		}
	}

	/*
	 * Java DFS solution 62ms by considering the problem as finding the longest
	 * path in a DAG
	 */
	// not a better Solution but a different type of solution.
	public class DFSSolution {

		/*
		 * 
		 * By considering each number as a node and its multiples as connected
		 * nodes. We can obtain a DAG. For example, [1,3,4,6] can form a DAG
		 * with edges of 1->3, 1->4, 1->6, 3->6. So, the answer is the longest
		 * path of 1->3->6.
		 * 
		 * This is very similar to the Topological sorting question which should
		 * be solved in O(|E|+|V|), linear running time. However, the bottleneck
		 * is that the edges are not given and we need to find those edges using
		 * O(|V|^2). Therefore, we need to find a better way to find the edges
		 * from a current node to all its connected nodes.
		 * 
		 * The idea is that we store all numbers in a TreeSet so they can be
		 * searched by order instead of going from small to large one by one.
		 * The advantage is that we can jump through the numbers that are not a
		 * multiple of the current node. i.e. use above example, when stop at 3,
		 * we can jump to 6 directly without visiting 4 by knowing the next
		 * multiple of 3 is 3X2=6. And, the next multiple is 3X3 and so on.
		 * 
		 * However, this is not enough when we have the case of the big gap, ie,
		 * [2, 10000, 10000001]. If we adding factor by one each time, it will
		 * take long long time. Therefore, here is the TreeSet coming handy. We
		 * find the ceiling of 4 to obtain 10000. In addition, we increase the
		 * factor to 10000/2 +1 for next round.
		 * 
		 * On the side node, this implementation use O(logN) to search the next
		 * multiple. A better implementation is to search only the TreeSet which
		 * only has numbers greater than the current number by cutting down the
		 * TreeSet. Or, using a sorted array and call Arrays.binarySearch(start,
		 * end, value).
		 */
		TreeSet<Long> mem = new TreeSet<Long>();
		long max = 0;
		List<Integer> ret = new ArrayList();
		Map<Long, List<Integer>> visited = new HashMap<>();

		public List<Integer> helper(long cur) {
			if (cur > max || !mem.contains(cur))
				return null;
			if (visited.containsKey(cur))
				return visited.get(cur);
			List<Integer> list = new ArrayList<>();
			long i = 2; // the factor for the next multiple of current value
			while (mem.ceiling(cur * i) != null) { // no more multiple
				// use O(log N) to find next multiple
				long next = mem.ceiling(cur * i);
				if (next % cur == 0) {
					List<Integer> temp = helper(next);
					if (temp != null && temp.size() > list.size())
						list = new ArrayList(temp);
				}
				i = (next / cur) + 1; // increase the factor based on the gap.
			}
			list.add((int) cur);
			visited.put(cur, list);
			return list;
		}

		public List<Integer> largestDivisibleSubset(int[] nums) {
			if (nums == null || nums.length == 0)
				return ret;
			int len = nums.length;
			if (len == 1) {
				ret.add(nums[0]);
				return ret;
			}
			for (int num : nums) {
				mem.add((long) num);
			}
			max = mem.last();
			for (int num : nums) {
				List<Integer> temp = helper(num);
				if (temp != null && temp.size() > ret.size())
					ret = new ArrayList(temp);
			}
			return ret;
		}
	}

	public static void main(String[] args) {

		LargestDivisibleSubset l = new LargestDivisibleSubset();
		DFSSolution dfs = l.new DFSSolution();
		int nums[] = { 3, 4, 8, 16 };
		System.out.println(dfs.largestDivisibleSubset(nums));

		BottomUp bt = l.new BottomUp();
		System.out.println(bt.largestDivisibleSubset(nums));

	}

}
