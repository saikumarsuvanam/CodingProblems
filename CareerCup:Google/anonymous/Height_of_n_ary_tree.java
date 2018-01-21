import java.util.ArrayList;

public class Height_of_n_ary_tree {
	class Node{
	int data;
	ArrayList<Node> children=new ArrayList<Node>();
	public Node(int item)
	{
		data = item;
	
	}
	public String toString(){
		
		return this.data+"";
	}}
	public int findHeight(Node root){
		int currentMax = 0;
		if(root==null){
			return 0;
		}
		if(root.children.size()==0){
			return 1;
		}
		for(Node n : root.children){
			int current = findHeight(n);
			if(current>currentMax){
				currentMax = current;
			}
		}
		return currentMax+1;

}
}
