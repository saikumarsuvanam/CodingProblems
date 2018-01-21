import java.util.*;

public class longest_path_from_any_node_to_other_node_in_narray_tree {

	class Node{
		int data;
		Node left, right;

		public Node(int item)
		{
			data = item;
			left = right = null;
		}
		public String toString(){
			
			return this.data+"";
		}
	}
	
			
		
		public static void main(String[] args) {
			longest_path_from_any_node_to_other_node_in_narray_tree t=new longest_path_from_any_node_to_other_node_in_narray_tree ();
			
			Node root = t.new Node(2);
			root.left = t.new Node(1);
			root.right=t.new Node(3);
			root.right.left=t.new Node(4);
			
			System.out.println(t.longestPath( root));
            System.out.println(t.path);
           
        
          
		}
		
		
		
		
			
			int max=0;
			Stack path;
			 Stack longestPath(Node root){
			if(root==null){
			Stack s=new Stack();
			return s;}
			Stack l=longestPath(root.left);
			Stack r=longestPath(root.right);
			
			
			
			if(l.size()+r.size()+1>max) {
				max = l.size()+r.size()+1;
				Stack tmp=new Stack();
				
				tmp.addAll(l);
				tmp.push(root);
				tmp.addAll(r);
				path=tmp;}

			l.push(root);
			r.push(root);
			
			return l.size()>r.size()?l:r;}
		
			 
				int max=0;
				Stack path;
				 Stack longestpath_n_ary_tree(Node root){
				if(root==null){
				Stack s=new Stack();
				return s;}
				for(Node n:root.children){
				Stack s=longestPath(n);
			Stack p= (Stack)s.clone();
			p.add(root);}
				if(l.size()+r.size()+1>max) {
					max = l.size()+r.size()+1;
					Stack tmp=new Stack();
					
					tmp.addAll(l);
					tmp.push(root);
					tmp.addAll(r);
					path=tmp;}

				l.push(root);
				r.push(root);
				
				return l.size()>r.size()?l:r;}

	
}
