package Easy;

import DS.TreeNode;

public class MirrorRepresentation {
	
	TreeNode mirrorConversion(TreeNode root){
		if(root==null){
			return null;
		}
		TreeNode temp=root.left;
		root.left=mirrorConversion(root.right);
		root.right=mirrorConversion(temp);
		return root;
		
	}

	// Driver program to test above functions
		public static void main(String args[]) {

			MirrorRepresentation l = new MirrorRepresentation();
			TreeNode root = new TreeNode(1);
			// Let us create trees shown in above diagram

			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);
			root.right.left = new TreeNode(6);
			root.right.right = new TreeNode(7);
			root.print();
			l.mirrorConversion(root);
			root.print();
			

		}

}
