package Easy;

import DS.DoublyLinkedList;
import DS.DoublyLinkedList.Node;
import DS.TreeNode;

public class BST_SortedDLL {

	TreeNode BSTtoDLL(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode lTail = BSTtoDLL(root.left);

		TreeNode rTail = BSTtoDLL(root.right);
		// Make a circular linked list of single node
		// (or root). To do so, make the right and
		// left pointers of this node point to itself
		root.left = root.right = root;

		TreeNode lmerge = merge(lTail, root);

		TreeNode rmerge = merge(lmerge, rTail);

		return rmerge;

	}

	TreeNode merge(TreeNode leftList, TreeNode rightList) {
		// If either of the list is empty, then
		// return the other list
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;

		// Store the last Node of left List
		TreeNode leftLast = leftList.left;
        TreeNode rightLast=rightList.left;
        leftLast.right=rightList;
        rightLast.left=leftLast;
        rightLast.right=leftList;
        leftList.left=rightLast;
	    return leftList;
	}

	public static void main(String args[]) {
		// Build the tree
		BST_SortedDLL d = new BST_SortedDLL();
		TreeNode root = new TreeNode(12);

		root.left = new TreeNode(10);
		root.right = new TreeNode(15);
		// root.left.left = new TreeNode(25);
		// root.left.right = new TreeNode(30);
		// root.right.left = new TreeNode(36);
		root.print();
		TreeNode head = d.BSTtoDLL(root);
		TreeNode temp=head;
		System.out.println(temp.data);
		while(temp.right !=head){
			temp=temp.right;
			System.out.println(temp.data);
		}

	}
}
