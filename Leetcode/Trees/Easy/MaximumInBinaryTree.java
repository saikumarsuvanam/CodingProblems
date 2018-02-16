package Easy;

import java.util.ArrayList;
import java.util.Stack;

import DS.TreeNode;

public class MaximumInBinaryTree {
	
	
	// An iterative function to do postorder traversal
		// of a given binary tree
		public TreeNode maximumInBT(TreeNode root) {
			if(root==null){
				return null;
			}
			else{
				TreeNode left	=maximumInBT(root.left);
				TreeNode right	=maximumInBT(root.right);
				TreeNode maxNode=root;
				if(left!=null && maxNode.data<left.data){
					maxNode=left;
				}
			 if(right!=null && maxNode.data<right.data){
					maxNode=right;
				}
				return maxNode;
				
				
			}
			

		}
	// Driver program to test above functions
		public static void main(String args[]) {

			MaximumInBinaryTree m=new MaximumInBinaryTree();
			TreeNode root = new TreeNode(1);
			// Let us create trees shown in above diagram

			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(9);
			root.right.left = new TreeNode(6);
			root.right.right = new TreeNode(7);
			root.print();
		System.out.println(	m.maximumInBT(root).data);
			
		}
}
