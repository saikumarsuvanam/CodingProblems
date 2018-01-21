import java.util.*;

/*https://www.careercup.com/question?id=5704108573982720
Implement delete operation for N-ary tree. Your function should return a list of roots after deletion operation. Notice that your delete function only delete one node instead of a subtree. The delete function takes a list of nodes to be deleted.

private class TreeNode {
  int val;
  TreeNode[ ] child;
}

List<TreeNode> delete(TreeNode root, HashSet<TreeNode> set)*/
class TNode {
    int val;
    ArrayList<TNode> childList;

    public TNode(int val, ArrayList<TNode> arrayList) {
        this.val = val;
        this.childList = arrayList;
    }
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("(").append(val);
        if (childList != null) {
            for (TNode childd: childList) {
                if (childd == null) continue;
                
                
                sb.append(childd.toString());
            }
        }
        sb.append(")");
        
        return sb.toString();
    }
}

public class delete_operation_in_narray_tree {

    private static TNode construct() {
    	
    	TNode node1 = new TNode(1, new ArrayList<TNode>());
    	TNode node2 = new TNode(2, new ArrayList<TNode>());
    	TNode node3 = new TNode(3, new ArrayList<TNode>());
    	TNode node4 = new TNode(4, new ArrayList<TNode>());
    	TNode node5 = new TNode(5, new ArrayList<TNode>());
    	TNode node6= new TNode(6, new ArrayList<TNode>());
    	TNode node7 = new TNode(7, new ArrayList<TNode>());
    	TNode node8 = new TNode(8, new ArrayList<TNode>());
    	TNode node9 = new TNode(9, new ArrayList<TNode>());
    	TNode node10 = new TNode(10, new ArrayList<TNode>());
    	//TNode node = new TNode(1, new ArrayList<TNode>());
    	
    	node1.childList.add(node2);
    	node1.childList.add(node3);
    	node1.childList.add(node4);
    	node4.childList.add(node5);
    	node4.childList.add(node6);
    	node5.childList.add(node7);
    	node5.childList.add(node8);
    	node6.childList.add(node9);
    	node9.childList.add(node10);
    	
    	
    	
       

        return node1;
    }

    private static void delete(TNode head,   HashSet<Integer> set, ArrayList<TNode> result) {
        ArrayList<TNode> list = head.childList;
        
        if(list!=null){
        	for(int i=0; i<list.size(); i++){
        		
        		
        if(set.contains(list.get(i).val)){
        	
        	set.remove(list.get(i).val);
        	if(!result.contains(head))
        	result.add(head);
        	 ArrayList<TNode> list1 =list.get(i).childList;
        	 
        	 for(int z=0;z<list1.size(); z++ ){
        		 
        		 if(set.contains(list1.get(z).val)){
        			 result.add(list.get(i));
        			 
        		 }
        		 
        	 }
        	
        	 if(!list1.isEmpty()){
        
        	 list.addAll(list1);
        	 list.remove(i);}
        	 
        	 else{
        		 list.remove(i);
        		 
        	 }
        	i--;
        	
        }
        
        
        else{ 	
       delete(list.get(i), set,result); 
        	
        }
        
        
        		
        	}
        	
        	
        	
        }}
        
        
      

    public static void main(String[] args) {
        TNode head = construct();
        
      
        ArrayList<TNode> result = new ArrayList<TNode>();// holds the result
 
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2);  set.add(3);set.add(4);
        delete(head, set, result);
        System.out.println("parent of the nodes which are  deleted:");
        for (TNode node : result) {
            System.out.print(node.val + " ");
        }
        System.out.println();
       
        System.out.println("tree after given nodes deleted:");
        
        
        System.out.println(head);
        
    }

}