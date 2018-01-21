/* google-interview-questions
Given a undirected graph with weights, return the sum of the weight of each path between two nodes 
(shortest path between two vertices). Assume there are no cycles.

Example:

Input:
       A
       | 1
       B
   2 /   \ 3
    C     D
    
Output:
18
since 
A to B has weight 1
A to C has weight 3
A to D has weight 4
B to C has weight 2
B to D has weight 3
C to D has weight 5

Edit: Thanks, wangchenClark0512, forgot about C to D
Edit2: @Lukas, The question is just the sum of the shortest paths between two vertices. 
Also, all edges are positive.
Edit3: Assume the graph has no cycles, did not get to the follow-up,
 but follow-up probably is probably change your algorithm so that is works for cycles
 
 The problem can be solved in O(n) time where n is the number of nodes.

Since the graph has no cycle, an edge e divides the graph into two sub graphs. 
For any path between the two graphs, the edge is always used exactly once. 
And there are (n1 * n2) number of possible paths between the sub-graphs (n1 is the number of nodes in 
sub-graph 1 and n2 is the number of the nodes in sub-graph 2). 
Therefore, the amount of value that the edge contributes to the final sum is 'w * n1 * n2, 
where w is the weight of the edge.

So, we basically calculate w * n1 * n2 for all edges and sum them up.
 Then how do we calculate n1 and n2? It is obvious that n1 + n2 = n, where n is the number of all 
 nodes in the graph. So we need to only calculate either n1 or n2.

At this point, let's treat the graph as a tree by taking an arbitrary node as root. 
Note that this possible since the graph does not have any cycle.

Then, we can solve the problem by traversing the tree and sum up (w * size of a sub-tree * (n - size of a sub-tree) when visiting a node.
 */
import java.util.*;
public class sum_of_all_weights_of_each_path_between_two_node_in_undirected_non_cyclic_graph {
	
	
	 class nTree{
		int weights;
		List<nTree> children;
		int size;
	    nTree (int data){
		 this.weights=data;
		 this.children=new ArrayList<nTree>();
		 
	   }
	}
	 /*
	   E           F
       4 \      / 5
             A
           1 |
             B
       2 /      \ 3
       C         D

  Answer is 1*3*3 + 2*1*5 + 3*1*5 + 4*1*5 + 5*1*5 = 79
	 
	  */

	 public static void main(String[] args){
		 
		 sum_of_all_weights_of_each_path_between_two_node_in_undirected_non_cyclic_graph t=new  sum_of_all_weights_of_each_path_between_two_node_in_undirected_non_cyclic_graph();
		 //lets start with A node in the above graph
		 nTree p=t.new nTree(0);//A
		 
	     p.children.add(t.new nTree(1));//B
		 p.children.add(t.new nTree(4));//E
		 p.children.add(t.new nTree(5));//F
		 p.children.get(0).children.add(t.new nTree(3));//D
		 p.children.get(0).children.add(t.new nTree(2));//C
		 int totalnodes=6;//we can program this also
			result r=t. new result(); //Instead of using static  here i am using a result  class
		 find_sum_of_all_weights(p,totalnodes,r);
		
		 System.out.println(r.sum);
	}
	 
	class result{ 
		int sum=0;
	}

 static  int  find_sum_of_all_weights(nTree p,int totalnodes,result r){
	    
    	int size = 1;
    	
    	if(p.children.size()==0){
    	return size;
    	}
    	else{
    		for(int i=0; i<p.children.size(); i++){
    		int s=find_sum_of_all_weights(p.children.get(i), totalnodes,r);
    		r.sum=r.sum+p.children.get(i).weights*s*(totalnodes-s);
    	     size=size+s;
            }
    	return size;
    	}
    }
}
