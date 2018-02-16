package Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DS.TreeNode;

//Give an algorithm for printing the level order data in reverse order. For example,
//the output for the below tree should be: 4 5 6 7 2 3 1
public class LevelOrderDataInReverseOrder {

	void levelOrderReverseTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		Stack<TreeNode>s = new Stack();
		while (!q.isEmpty()) {
			root = q.poll();

			if (root.right != null)
				q.add(root.right);
			if (root.left != null)
				q.add(root.left);
			s.push(root);

		}
		while(!s.isEmpty()){
		System.out.println(s.pop().data);
		}

	}

	// Driver program to test above functions
	public static void main(String args[]) {

		LevelOrderDataInReverseOrder l = new LevelOrderDataInReverseOrder();
		TreeNode root = new TreeNode(1);
		// Let us create trees shown in above diagram

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.print();
		l.levelOrderReverseTraversal(root);
		

	}
}
