/*https://www.careercup.com/question?id=5633261887815680
Convert left-right representation of a binary tree to down-right

Left-Right representation of a binary tree is standard representation where every node has a pointer to left child and another pointer to right child.

Down-Right representation is an alternate representation where every node has a pointer to left (or first) child and another pointer to next sibling. So siblings at every level are connected from left to right.

Given a binary tree in left-right representation as below

                               1
		            /    \
		           2	  3
			       /    \
 			      4      5
		             /     /   \
		            6    7      8 

Convert the structure of the tree to down-right representation like the below tree.

			1
			|
			2 – 3
			    |
			    4 — 5
			    |   |
			    6   7 – 8 
 * 
 */
public class convert_left_right_representation_BT_to_down_right {
	
	class Node{
		Node left;
		Node right;
		int data;
		Node (int data){
			this.data=data;
			left=null;right=null;
		}
	}
	public static void main(String[] args) {
		convert_left_right_representation_BT_to_down_right t = new convert_left_right_representation_BT_to_down_right();
	        
	   Node root = t.new Node(1);
	    root.left = t.new Node(2);
	    root.right = t.new Node(3);
	    root.right.left =t. new Node(4);
	    root.right.right = t.new Node(5);
	    root.right.left.left = t.new Node(6);
	    root.right.right.left = t.new Node(7);
	    root.right.right.right = t.new Node(8);
	   convert_to_down_right(root);
	    downRightTraversal( root);
	}
	
	
	static void downRightTraversal(Node root)
	{
	    if (root != null)
	    {
	        System.out.println(root.data);
	        downRightTraversal(root.right);
	        downRightTraversal(root.left);
	    }
	}
	static Node convert_to_down_right(Node root){
		if(root.left==null &&root.right==null){
			return root;
		}
	 Node leftNode=convert_to_down_right(root.left);
	 leftNode.right=root.right;
	 root.right=null;
	 if(leftNode.right!=null)
	return convert_to_down_right(leftNode.right);
	 else return root;
		
	
}


}