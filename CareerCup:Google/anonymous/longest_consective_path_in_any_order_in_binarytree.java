


/*Find longest consecutive path in a binary tree.
  
 https://www.careercup.com/question?id=5689208527126528
1. the path can be decreasing or increasing, i.e [1,2,3,4] and [4,3,2,1] are both valid
2. the path can be child-parent-child, not necessarily a parent-to-child path
logic:
The longest path has to be rooted in one node and it is the concatenation of the longest path on the left, the node, and the longest path on the right. For each node, find the longest path rooted on it and find the max of all.
calculating the length of increasing and decreasing sequence for both left and right child
similar to this question: http://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/*/
import java.util.*;
public class longest_consective_path_in_any_order_in_binarytree {

	

	
	class Node{
		int data;
		Node left, right;
		public Node(int x){
			data=x;
			left=right=null;
		}
		
		public String toString(){
			
			return Integer.toString(data);
			
			
			
		}
	}
	class Result{
		int inc,dec;
		LinkedList<Node> in=new LinkedList<Node>();
		
		
		LinkedList<Node> de=new LinkedList<Node>();
		int max;
		LinkedList<Node> maxpath=new LinkedList<Node>();
	}
	
	
		
		public static void main(String[] args) {
			longest_consective_path_in_any_order_in_binarytree t=new longest_consective_path_in_any_order_in_binarytree();
			
			Node n=t.new Node(6);
			n.left=t.new Node(5);
			n.left.left=t.new Node(3);
			n.left.right=t.new Node(4);
			n.left.left.left=t.new Node(2);
			n.right=t.new Node(7);
			n.right.left=t.new Node(8);
			n.right.left.right=t.new Node(9);
			Result r=lcs(n);
			System.out.println(r.max);
			System.out.println(r.maxpath);
		}

		private static Result lcs(Node n) {
			longest_consective_path_in_any_order_in_binarytree t=new longest_consective_path_in_any_order_in_binarytree();
			Result res=t.new Result();
			if(n==null){
				res.dec=0;	res.inc=0;
				res.max=0;
				res.maxpath=null;
				return res;
			}
			res.dec=1; res.inc=1;
			res.in.add(n);
			res.de.add(n);
		
			Result l=lcs(n.left);
			Result r=lcs(n.right);
			if(n.left!=null){
				if(n.left.data+1==n.data){
					res.inc+=l.inc;
					res.in.addAll(l.in);
				
					
				}
				if(n.data+1==n.left.data){
					res.dec+=l.dec;
					res.de.addAll(l.de);
				}
			}
			if(n.right!=null){
				if(n.right.data+1==n.data){
					res.inc=Math.max(res.inc,r.inc+1);
					if(res.inc==r.inc+1){
						LinkedList<Node> p=new LinkedList<Node>();
						p.add(n);
						p.addAll(r.in);
						res.in=p;
						
					}
					
				}
				if(n.right.data==n.data+1){
					res.dec=Math.max(res.dec,r.dec+1);
					if(res.dec==r.dec+1){
						LinkedList<Node> p=new LinkedList<Node>();
					
					
						p.add(n);
						p.addAll(r.de);
						res.de=p;
						
					}
					
				}
			}
			
		
			res.max=Math.max(findLen(n,l,r).max, l.max);
			res.max=Math.max(res.max, r.max);
			
			
			
			 if(res.max==findLen(n,l,r).max){
				
				res.maxpath=findLen(n,l,r).maxpath;
				
				
			}
			 
			 else  if(res.max==l.max){
					
					res.maxpath=l.maxpath;
					//System.out.println(l.maxpath);
				}
			
			else {res.maxpath=r.maxpath;
			//System.out.println(r.maxpath);
			}
			
			// System.out.println(res.maxpath);
			return res;
		}

		private static Result findLen(Node n, Result l, Result r) {
			int len=0;
			
			LinkedList<Node> finalpath=new LinkedList<Node> ();
			finalpath.add(n);
			if(n.left!=null && n.right!=null){
				if(n.data+1==n.left.data && n.data==n.right.data+1){
					len=l.dec+r.inc+1;
					
					finalpath.addAll(l.de);
					
					finalpath.addAll(r.in);
			
					
					
				}
				else if(n.data==n.left.data+1 && n.data+1==n.right.data){
					len=l.inc+r.dec+1;
					
					
					finalpath.addAll(l.in);
					
					finalpath.addAll(r.de);
					
				}
				
				else if(n.data+1==n.left.data){
					len=1+l.dec;
					
					finalpath.addAll(l.de);
					
				}
				else if(n.data==n.left.data+1){
					len=1+l.inc;
					
					
					finalpath.addAll(l.in);	
				}
				
				else if(n.data+1==n.right.data){
					len=1+r.dec;
				
					finalpath.addAll(r.de);
				}
				else if(n.data==n.right.data+1){
					len=1+r.inc;
				
					finalpath.addAll(r.in);
				}
			
			}
		else if(n.left!=null){
				if(n.data+1==n.left.data){
					len=1+l.dec;
					
					finalpath.addAll(l.de);
					
				}
				else if(n.data==n.left.data+1){
					len=1+l.inc;
					
					
					finalpath.addAll(l.in);	
				}}
			
		else	if(n.right!=null){
			 if(n.data+1==n.right.data){
					len=1+r.dec;
				
					finalpath.addAll(r.de);
				}
				else if(n.data==n.right.data+1){
					len=1+r.inc;
				
					finalpath.addAll(r.in);
				}}
			
			//System.out.println(finalpath);
			longest_consective_path_in_any_order_in_binarytree t=new longest_consective_path_in_any_order_in_binarytree();
			Result k=t.new Result();
			k.maxpath.addAll(finalpath);
			k.max=len;
			return k;
		}

	}