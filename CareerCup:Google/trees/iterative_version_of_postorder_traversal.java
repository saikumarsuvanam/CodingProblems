import java.util.ArrayList;
import java.util.Stack;
/*http://www.geeksforgeeks.org/iterative-postorder-traversal/
 * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 */
//Find itervative version of postorder traversal
public class iterative_version_of_postorder_traversal {


		class Node {
			 
		    int data;
		    Node left, right;
		 
		    Node(int item) {
		        data = item;
		        left = right = null;
		    }
		} 
		
		public static void main(String args[]) {
			iterative_version_of_postorder_traversal     tree = new iterative_version_of_postorder_traversal();
		
	        Node root =tree. new Node(10);
	        root.left = tree.new Node(8);
	        root.right = tree.new Node(2);
	        root.left.left = tree.new Node(3);
	        root.left.right = tree.new Node(5);
	        root.right.left =tree. new Node(2);
	      //  tree.iterativePostorder(root);//using single stack
	        tree.two_stacks_iterativePostorder(root);//using two stacks
	 
	    }
		
	/* using single stack
	 * 1.1 Create an empty stack
		2.1 Do following while root is not NULL
	    a) Push root's right child and then root to stack.
	    b) Set root as root's left child.
	2.2 Pop an item from stack and set it as root.
	    a) If the popped item has a right child and the right child 
	       is at top of stack, then remove the right child from stack,
	       push the root back and set root as root's right child.
	    b) Else print root's data and set root as NULL.
	2.3 Repeat steps 2.1 and 2.2 while stack is not empty	
	*/	
	void 	iterativePostorder(Node root){
			if(root==null){
				return ;
			}
			Stack<Node> s=new Stack<Node>();
			
		  
		  Node curr=root;
		  s.push(curr);
		   int i=1;
			while(!s.isEmpty()){
			   if(i==1){
				 curr=s.pop();
				 i=0;}
		       //go to the left nodes while going store root and root-> right nodes
				while(curr!=null){
					if(curr.right!=null){
						s.push(curr.right);}
				     s.push(curr);		
	                 curr=curr.left;
		        }
		
                if(s.size()>=2 && s.peek().right!=null && s.peek().right.equals(s.get(s.size()-2))){
					Node temp=	s.pop();
					curr=s.pop();
	    	        s.push(temp);
                }
				else{
				   System.out.println(s.peek().data);
					s.pop();
					curr=null;
				   
				}
				
		    }
	}
	/*
	1. Push root to first stack.
	2. Loop while first stack is not empty
	   2.1 Pop a node from first stack and push it to second stack
	   2.2 Push left and right children of the popped node to first stack
	3. Print contents of second stack
	*/
	void two_stacks_iterativePostorder(Node root){
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		if(root==null){
			return;
		}
		else {
			s1.push(root);
		}
		while(!s1.isEmpty()){
			Node curr=s1.pop();
			if(curr.left!=null){
				s1.push(curr.left);
			}
			if(curr.right!=null){
				s1.push(curr.right);
			}
			s2.push(curr);
			
		}
	// print contents of stack s2
		for(int i=s2.size()-1; i>=0;i--){
			System.out.println(s2.get(i).data);
		}
	
}
		
}	
	

