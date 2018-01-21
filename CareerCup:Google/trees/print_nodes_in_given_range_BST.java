/*https://www.careercup.com/question?id=5148430339932160

Can you augment a BST to return the number of elements with node values in a given range?
If not, what other data structure would work?
*/

/* i did it in simple way we can also do by using segment trees in o(logn) time */
import java.util.*;
public class print_nodes_in_given_range_BST {
	Node root;
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
		// TODO Auto-generated method stub
		  
		       print_nodes_in_given_range_BST tree = new print_nodes_in_given_range_BST();
		        int k1 = 10, k2 = 25;
		        tree.root = tree.new Node(20);
		        tree.root.left = tree.new Node(8);
		        tree.root.right =tree. new Node(22);
		        tree.root.left.left = tree.new Node(4);
		        tree.root.left.right = tree.new Node(12);
		 
		        Print(tree.root, k1, k2);
		    }
	
     static void Print(Node root, int k1, int k2){
    	if(root==null) return; 
		if(root.data>k1 && root.data>k2 ){
			Print(root.left,k1,k2);
		}
		else if(k1<=root.data && root.data<=k2){
			System.out.println(root.data);
			Print(root.left,k1,k2);
			Print(root.right,k1,k2);
		}
		else {
			Print(root.right,k1,k2);
		}
	}

}
