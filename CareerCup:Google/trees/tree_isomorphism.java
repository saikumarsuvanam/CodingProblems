import CtCILibrary.TreeNode;

//https://www.careercup.com/question?id=5726815775621120
//http://www.geeksforgeeks.org/tree-isomorphism-problem/
/*Write a function to detect if two trees are isomorphic. Two trees are called isomorphic if one of them 
 * can be obtained from other by a series of flips, i.e. by swapping left and right children of a 
 * number of nodes. Any number of nodes at any level can have their children swapped. 
 * Two empty trees are isomorphic.
*/
public class tree_isomorphism {
      public static void main(String[] args){
    	  
    	TreeNode root1 = new TreeNode(1);
    	TreeNode root2=new TreeNode(1);
          
          // Let us create trees shown in above diagra
    	root1.left = new TreeNode(2);
          root1.right = new TreeNode(3);
          root1.left.left = new TreeNode(4);
         root1.left.right = new TreeNode(5);
          root1.right.left = new TreeNode(6);
          root1.left.right.left = new TreeNode(7);
          root1.left.right.right = new TreeNode(8);
    
         
          root2.left = new TreeNode(3);
          root2.right=new TreeNode(2);
          root2.right.left=new TreeNode(4);
          root2.right.right = new TreeNode(5);
          root2.left.right = new TreeNode(6);
          root2.right.right.left = new TreeNode(8);
          root2.right.right.right = new TreeNode(7);
          System.out.println(isIsomorphic(root1,root2));
          print(root1);
          print(root2);
          
    }
      static void print(TreeNode root){
    	  if(root==null)return;
    	  print(root.left);
    	  System.out.println(root.data);
    	  print(root.right);
      }
      static boolean isIsomorphic_without_changing_given_tree(TreeNode n1,TreeNode n2){
    	  
    	  if (n1 == null && n2 == null)
              return true;
    
          // Exactly one of the n1 and n2 is NULL, trees not isomorphic
          if (n1 == null || n2 == null)
              return false;
    
          if (n1.data != n2.data)
              return false;
    
          // There are two possible cases for n1 and n2 to be isomorphic
          // Case 1: The subtrees rooted at these nodes have NOT been 
          // "Flipped". 
          // Both of these subtrees have to be isomorphic.
          // Case 2: The subtrees rooted at these nodes have been "Flipped"
          return (isIsomorphic(n1.left, n2.left) && 
                                           isIsomorphic(n1.right, n2.right))
          || (isIsomorphic(n1.left, n2.right) && 
                                           isIsomorphic(n1.right, n2.left));
      }
      
      
     
      //another method- my method which makes both tree equivalent by flipping i.e changing the given tree.
      static  boolean isIsomorphic(TreeNode root1,TreeNode root2){
    	  if(root1==null && root2==null)return true;
    	  else if(root1==null||root2==null){
    		  return false;
           }
    	 else if(root1.data!=root2.data){
    		  return false;
    	  }
    	  boolean left= isIsomorphic(root1.left, root2.left);
    	  if(!left){
    		  TreeNode temp=root1.left;
    		  root1.left=root1.right;
    		  root1.right=temp;
    	  }
    	 left=isIsomorphic(root1.left, root2.left);
    	 boolean right=isIsomorphic(root1.right, root2.right);
		  if(left &&right){
			  return true;
		  }
		  else return false;
      }
      
}
