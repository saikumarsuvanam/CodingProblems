package Easy;
import DS.TreeNode;;

public class ValidateBST {
	
	boolean validateBST(TreeNode node,Long minValue,Long maxValue){
		if(node==null) return true;
		if(node.data<=minValue||node.data>=maxValue){
			return false;
		}
		else return validateBST(node.left,minValue,new Long(node.data)) && 
				validateBST(node.right,new Long(node.data),maxValue);
	}
	
	
	public static void main(String[] args) {
		ValidateBST v=new ValidateBST();
		/* Simple test -- create one */
		int[] array = { Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE };
		TreeNode node = TreeNode.createMinimalBST(array);
		// node.left.data = 6; // "ruin" the BST property by changing one of the
		// elements
		node.print();
		boolean isBst = v.validateBST(node,Long.MIN_VALUE,Long.MAX_VALUE);
		System.out.println(isBst);
	}

	

}
