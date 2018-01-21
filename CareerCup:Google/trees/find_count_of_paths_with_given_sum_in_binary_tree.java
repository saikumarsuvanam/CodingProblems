import java.util.*;
import CtCILibrary.TreeNode;
/*This question to return  all the paths that sum to given value. 
the path does not start or end at the root or a leaf,but it must go downwards,(travelling 
from parent nodes to child nodes)*/
//Question is in cracking the coding interview book(page no-272) there it asked only 
//count of paths.
public class find_count_of_paths_with_given_sum_in_binary_tree {
	
	
	//below is simple brute force. checkanother solution for optimum implemented at the end.
	//0(n*n) because of checking path sum every time.
	/*i went straight from root to left and checked that path sum and then 
	 * went to right
	 */
	static void findpaths(TreeNode root,ArrayList path, int sum){
		if(root==null) return;
		path.add(root.data);
		findpaths(root.left,path,sum);
		
		int runningsum=0;
		for(int j=path.size()-1; j>=0; j--){
			runningsum+=(int)path.get(j);
			
			if(runningsum==sum){
				print(path,j);
			}
		}
	 	
	   findpaths(root.right,path,sum);
	   path.remove(path.size()-1);
		
	}
    static 	void print(ArrayList path,int j){
    	for(int i=path.size()-1; i>=j; i--){
    	  System.out.print(path.get(i)+ ",");
		}
        System.out.println();
    }    
    	
    
    
    //from here onwards best solution designed using hashtable.
    //please refer craking the coding interview bookin 274 page.
    static void bestfindpaths(TreeNode root,int runningsum,int targetsum,HashMap map,ArrayList datalist){
    	
    	if(root==null) return;
    	runningsum+=root.data;
    	datalist.add(root.data);
    	
    	int sum=runningsum-targetsum;
    	//print if sum exists in hashmap
    	print(map,sum,datalist, targetsum,runningsum);
    	
        
        //Hashmap incrementing
        if(map.containsKey(runningsum)){
        	List l=(List)map.get(runningsum);
        	l.add(datalist.size()-1);
        	map.put(runningsum, l);
        }
        else {
        	List l=new ArrayList();
        	l.add(datalist.size()-1);
        	map.put(runningsum, l);
        	
        }
        
        bestfindpaths(root.left,runningsum, targetsum, map, datalist);
    	bestfindpaths(root.right,runningsum,targetsum,map,datalist);
    	
    	//hashmap decrementing
    	List l=(List)map.get(runningsum);
    	if(l.size()==0)
    		 map.remove(runningsum);
        else {
        	l.remove(l.size()-1);
        	if(l.size()==0) map.remove(runningsum);
        	else map.put(runningsum, l);
        }
    	//remove the data everything is over	
    	datalist.remove(datalist.size()-1);
    	
    }
    	
   static void print(HashMap map, int sum, ArrayList datalist,int targetsum,int runningsum){	
    List indiceslist=new ArrayList();
    if(map.containsKey(sum)){
    	 indiceslist=(List)map.get(sum);
    
    
    for(int i=0; i<indiceslist.size();i++){
    	for(int j=(int)indiceslist.get(i);j<datalist.size()-1; j++){
    		System.out.print(datalist.get(j+1)+" ");
    	}
    	System.out.println();
    }
    }
    if(runningsum==targetsum){
    	for(int i=0;i<datalist.size();i++ ){
    		System.out.print(datalist.get(i)+" ");
        }
    	System.out.println();
    }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(-4);
		root.left.right = new TreeNode(1);
	root.right.left.right=new TreeNode(1);
		/*root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		*/
		
		ArrayList path=new ArrayList();
 	    //findpaths(root,path,sum);	
 	    int runningsum=0;
 	    int targetsum=0;
 	    HashMap<Integer,ArrayList> map=new   HashMap<Integer,ArrayList> ();
 	    ArrayList datalist=new ArrayList();
 	   bestfindpaths(root, runningsum, targetsum, map,datalist);
	}

}
