import java.util.Arrays;

/*

Write a class DominoChecker that has a method called addBox(int[]) that takes a box of five dominoes, 
described as a list of 10 integers (explained after), adds it to a collection, and returns true if a box with 
the same dominoes was already in the collection and false otherwise. A box of dominoes is encoded as a list of 
10 integers from 0 to 9, where a pair of numbers represent a domino. For example: 0,2,9,1,3,3,7,4,5,6 
represents a box containing dominoes: (0,2); (9,1); (3,3); (7,4); (5,6). http://en.wikipedia.org/wiki/Dominoe
s for more basic info (like pictures)
 * 
 */
public class object_check_forequals_class {

	public class DominoChecker{
	      
		
		public int addBox(int[] box){
			
			Arrays.sort(box);
			
			
			
		}
		
		
		
	}
	public static void main(String[] args) {
		DominoChecker checker = new DominoChecker();
		int[] box1 = {0,2,9,1,3,3,7,4,5,6};
		int[] box2 = {0,2,3,3,5,6,7,4,9,1};
		System.out.println(checker.addBox(box1));
		System.out.println(checker.addBox(box2));
		
		int[] box3 = {0,1,3,2,5,6,7,4,9,1};
		System.out.println(checker.addBox(box3));
	
		int[] box4 = {3,3,3,1,1,1,7,3,3,1};
		int[] box5 = {7,3,1,1,1,3,3,1,3,3};
		System.out.println(checker.addBox(box4));
		System.out.println(checker.addBox(box5));
	}
}

