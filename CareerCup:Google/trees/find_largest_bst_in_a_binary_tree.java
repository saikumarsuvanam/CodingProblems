//http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
public class find_largest_bst_in_a_binary_tree {
class Node {
	 
	    int data;
	    Node left, right;
	 
	    Node(int d) {
	        data = d;
	        left = right = null;
	    }
	}
	 
	class Value {
	 
	    int max_size = 0; // for size of largest BST
	    boolean is_bst = false;
	    int min = Integer.MAX_VALUE;  // For minimum value in right subtree
	    int max = Integer.MIN_VALUE;  // For maximum value in left subtree
	 
	}
	 
	
	 
	    static Node root;
	   
	 
	    /* Returns size of the largest BST subtree in a Binary Tree
	     (efficient version). */
	    int largestBST(Node node) {
	 
	        Value val=largestBSTUtil(node);
	 
	        return val.max_size;
	    }
	    
	   Value largestBSTUtil(Node node){
		   Value val = new Value();
	    	if(node==null){
	    		
	    		 val.is_bst=true;
	    		 val.max_size=0;
	    		 val. min = Integer.MAX_VALUE;  
	    		    val. max = Integer.MIN_VALUE;
	    		    return val;
	    		 
	    	}
	    	Value left=largestBSTUtil(node.left);
	    	Value right=largestBSTUtil(node.right);
	    	if(left.is_bst&&right.is_bst&&node.data>=left.max&&node.data<right.min){
	    		val.max_size=1+left.max_size+right.max_size;
	    		val.is_bst=true;
	    		val.min=left.min;
	    		val.max=right.max;
	    		 if(val. min == Integer.MAX_VALUE){
	    			 val.min=node.data;
	    		 }
	    		 
	    		  if( val. max == Integer.MIN_VALUE){
	    			   val.max=node.data;
	    		   }
	    		  
		    		
	    		
	    		return val;
	    	}
	    	else if(left.is_bst&&right.is_bst){
	    		if(left.max_size>right.max_size){
	    			val=left;
	    		}
	    		else {
	    			
	    			val=right;
	    		}
	    		val.is_bst=false;
	    		return val;
	    		
	    	}
	    	
	    	else{
	    		if(left.is_bst){
	    			val=left;
	    			
	    		}
	    		else if(right.is_bst){
	    			val=right;
	    			
	    		}
	    		val.is_bst=false;
    			return val;
	    	}
	    }

	public static void main(String[] args) {
        /* Let us construct the following Tree
                50
             /      \
            10        60
           /  \       /  \
          5   20    55    70
                   /     /  \
                  45   65    80
         */
 
		find_largest_bst_in_a_binary_tree tree = new find_largest_bst_in_a_binary_tree();
        tree.root = tree.new Node(50);
        tree.root.left = tree.new Node(10);
        tree.root.right = tree.new Node(60);
       tree.root.left.left = tree.new Node(12);
       tree.root.left.right = tree.new Node(20);
       tree.root.right.left = tree.new Node(55);
        tree.root.right.left.left =tree. new Node(45);
        tree.root.right.right = tree.new Node(70);
        tree.root.right.right.left = tree.new Node(65);
        tree.root.right.right.right = tree.new Node(80);
 
        /* The complete tree is not BST as 45 is in right subtree of 50.
         The following subtree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
        */
        System.out.println("Size of largest BST is " + tree.largestBST(root));
    }
}