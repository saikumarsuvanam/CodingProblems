import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class find_duplicate_subtrees_in_binary_tree {

	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) {val = x;}
	}
	
	
	

	    static TreeNode root;
	    
	    public static void main(String[] args) {
	    	
	   find_duplicate_subtrees_in_binary_tree t=new find_duplicate_subtrees_in_binary_tree();	
	   root = t.new TreeNode(1);
	    TreeNode a = t.new TreeNode(2);
	    TreeNode b = t.new TreeNode(3);
	    TreeNode c = t.new TreeNode(4);
	    TreeNode d = t.new TreeNode(2);
	    TreeNode e = t.new TreeNode(4);
	    TreeNode f = t.new TreeNode(4);
            root.left=a;
            a.left=c;
            root.right=b;
            b.left=d;
            d.left=e;
            b.right=f;
	      List duplicates=hasDuplicateSubtrees( root);
	      
	      for(int i=0; i<duplicates.size();i++){
	    	TreeNode r=(TreeNode)duplicates.get(i);
	      System.out.println(r.val);
	       
	    }
	    }
	    private static Set<String> seen = new HashSet<>();
	    private static Map<String, TreeNode> dupes = new HashMap<>();

	    public static List<TreeNode> hasDuplicateSubtrees(TreeNode root) {
	        recursiveVerify(root);
	        System.out.println(dupes.keySet());
	        return new ArrayList<>(dupes.values());
	    }

	    private static String recursiveVerify(TreeNode curr) {
	        if(curr == null) return "N";

	        String lVal = recursiveVerify(curr.left);
	        String rVal = recursiveVerify(curr.right);

	        String signature = lVal + "I" + Integer.toString(curr.val) + "I" + rVal;
	        
	        if(seen.contains(signature)) {
	            if(!dupes.containsKey(signature)) {
	                dupes.put(signature, curr);
	            }
	        }
	        seen.add(signature);
	        return signature;
	    }
	    
	    
	
	
}
	    
	    
	    

	

	
