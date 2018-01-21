import java.util.*;

//http://cpluspluslearning-petert.blogspot.co.uk/2016/11/bts-find-deepest-path.html

//www.zrzahid.com/binary-tree-all-paths-max-sum-path-diameter-longest-path-shortest-path-closest-leaf/
public class deppestpath_in_tree {

	class Node{
		int data;
		Node left, right;
		public Node(int x){
			data=x;
			left=right=null;
		}
	}
	
	
		public static int max;
		public static void main(String[] args) {
			
			deppestpath_in_tree t	=new deppestpath_in_tree();
			Node n=t. new Node(6);
			n.left=t.new Node(5);
			n.left.left=t.new Node(3);
			n.left.right=t.new Node(4);
			//n.left.right.right=t.new Node(4);
			//n.left.right.right.right=t.new Node(4);
			n.left.left.left=t.new Node(2);
			n.right=t.new Node(7);
			n.right.left=t.new Node(8);
			n.right.left.right=t.new Node(9);
			n.right.left.right.left=t.new Node(9);
			//n.right.left.right.right=t.new Node(9);
			ArrayList<Integer> p=new ArrayList<Integer> ();
			ArrayList<Integer> s=new ArrayList<Integer> ();
			//System.out.println(longestConsecutiveUtil(n));
			ArrayList<Integer>path=new ArrayList<Integer>();
			//ArrayList<ArrayList<Integer>> allpaths=new ArrayList<ArrayList<Integer>>();
			maximumpaths(n,path);
			String x="";
			ArrayList<String> path1=new ArrayList<String>();
		paths	(n,x,path1);
		System.out.println(allpaths);
		}
		
	
	static	ArrayList<Integer> longestConsecutiveUtil(Node root)
		{
				
		if(root==null) {		
			ArrayList<Integer> o=new ArrayList<Integer> ();	
			return o;
		}
		
				
		else{

			
			
		 ArrayList<Integer> l=longestConsecutiveUtil(root.left);
		ArrayList<Integer> r=longestConsecutiveUtil(root.right);
			
			
		if(l.size()==r.size()){
			
		
			l.add(0,root.data);
		
			
		
			r.add(0,root.data);
			
			for(int i=0; i<2; i++){
			if(i==0)
			return l;
			if(i==1){
				return r;
			}
			
		}
			}
		
			if(l.size()>r.size()) {
			
			
			l.add(0,root.data);
			return l;
				
			}
			
			
			else {
				
			
				
				r.add(0,root.data);
				return r;
		
			
			}
			
			
			
	
		}
		
		}
	
	//find all paths which are maximum height using DFS approach
	static ArrayList<ArrayList<Integer>> allpaths=new ArrayList<ArrayList<Integer>>();
	//Do a DFS 
	static int max1=0;
static void	maximumpaths(Node root,ArrayList<Integer>path){
		
	if(root==null) return ;
 if(root.left==null && root.right==null){
path.add(root.data);		
	if(path.size()>max1){
	   max1=path.size();
	  allpaths.clear(); 
	 allpaths.add(path);
   }
   else if(path.size()==max1){
	  
	   allpaths.add(path); 
   }
	}
	 else{
         path.add(root.data);
 ArrayList<Integer> path2= (ArrayList<Integer>)path.clone();
 maximumpaths(root.left,path);
 

	 
        
	
 maximumpaths(root.right,path2);
	
		
	 }
		
	}
	
//Another method for finding the same problem above 
public static void paths(Node root, String path, ArrayList<String> paths){
	 if(root == null){
		 return;
	 }
	 
	 path=path+(path.isEmpty()? "" : "-->")+root.data;
	 if(root.left == null && root.right == null){
		 System.out.println("path > "+path);
		 paths.add(path);
		 return;}
	 paths(root.left, path, paths);
	 paths(root.right, path, paths);
}	
	
}
		

		
	

