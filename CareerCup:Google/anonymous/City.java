/* You are given a graph with no cycles, each node representing different cities and there are stadiums 
 * for baseball games in all cities.

Each node contains a value representing the population of the city, and a list of neighbors. 
(feel free to extend data structure)

Every time there is a baseball game at a city, everyone from all the different cities will go to the 
city with the baseball game.

Return the maximum traffic between a city and its neighbours when there is a game at that city, 
for all cities. (Does not have to be sorted)

The total run-time after returning everything should be O(n).

Examples:

Input:
1   2
 \ /
  5
 / \
4   3
Output:
1 14
2 13
3 12
4 11
5 4

Input:
         38
         /
        8
        /
      7
     /
1   2
 \ / \
  5   15
 / \
4   3
Output:
1 82
2 53
3 80
4 79
5 70
7 46
15 68
8 38
38 45
*/
import java.util.*;



//(a undirected acyclic graph is nothing but a tree)
class City{ 

	class nTree{
		int weights;
		List<nTree> children;
		int size;
	    nTree (int data){
		 this.weights=data;
		 this.children=new ArrayList<nTree>();
		 
	   }
	}
	
	public static void main(String[] args){
		 
      City  t=new  City();
	  nTree p=t.new nTree(1);
	  p.children.add(t.new nTree(5));
	  p.children.get(0).children.add(t.new nTree(3));
	  p.children.get(0).children.add(t.new nTree(2));
	  p.children.get(0).children.add(t.new nTree(4));
	 find_traffic_for_each_node(p);
		
		 
	}
	static int parentsum;
	static int childsum;
	static int max=0;
	static void find_traffic_for_each_node(nTree p){
	parentsum +=p.weights;
	if(p.children.size()==0){
		childsum =p.weights;
		return;
	}
	
	fot i=0; i<p.children.size(); i++){
		
		find_traffic_for_each_node(p.children.get(i));
	    if(max<childsum){
	    	max=childsum;
	    }
	}
	
	//System.out.println("for "+p.weights +" "+Math.max(max, parentsum-p.weights));
		//return;
	}
	
	
	
}