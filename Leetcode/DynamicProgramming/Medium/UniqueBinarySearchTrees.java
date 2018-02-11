package Medium;

//95. Unique Binary Search Trees II https://leetcode.com/problems/unique-binary-search-trees-ii/description/
/*Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * 
 */
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}

		return helper(1, n);
	}

	// Hint This problem can be solved by recursively forming left and right
	// subtrees. The different combinations of left and right subtrees form the
	// set of all unique binary search trees.
	public List<TreeNode> helper(int m, int n) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (m > n) {
			result.add(null);
			return result;
		}

		for (int i = m; i <= n; i++) {
			List<TreeNode> ls = helper(m, i - 1);
			List<TreeNode> rs = helper(i + 1, n);
			for (TreeNode l : ls) {
				for (TreeNode r : rs) {
					TreeNode curr = new TreeNode(i);
					curr.left = l;
					curr.right = r;
					result.add(curr);
				}
			}
		}

		return result;
	}
}
