package Easy;

import java.util.ArrayList;
import java.util.Stack;

import DS.TreeNode;

class IterativePostOrderTraversal {

	// An iterative function to do postorder traversal
	// of a given binary tree
	ArrayList<Integer> postOrderIterative(TreeNode root, ArrayList<Integer> list) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode previous=null;
		do {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (root == null) {
				root = s.peek();
				//previous is if the element is already popped from the stack then you dont want to add the
				// item again in the stack. so root.right==previous internally meaning root.right=null.
				if (root.right == null||root.right==previous) {
					s.pop();  
					list.add(root.data);
					//System.out.println(root.data);
			         previous=root;
					 root=null;
				} else {
					root = root.right;
					
				}
			}
		} while (!s.isEmpty());
		return list;

	}

	// Driver program to test above functions
	public static void main(String args[]) {
		IterativePostOrderTraversal it = new IterativePostOrderTraversal();

		TreeNode root = new TreeNode(1);
		// Let us create trees shown in above diagram

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.print();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> mylist = it.postOrderIterative(root, list);

		System.out.println("Post order traversal of binary tree is :");
		System.out.println(mylist);
	}
}
