	import java.util.*;
	
	//http://cpluspluslearning-petert.blogspot.co.uk/2017/01/dsa-minimum-swap-to-reach-desired.html
	
/*1. Problem Description
This is a Google interview question for software engineer from careercup. Here is the original thread, "
An interesting question asked in Google’s phone interview : suppose a row of parking lot with n spots, one of them is empty and n-1 spots are occupied with cars. Only one operation is allowed: move one car from its position to the empty spot. Given a initial order of cars and a final order, output steps needed to convert initial order to final oder with that operation.

Follow up: Minimize steps needed.

ex:

{1 2 3 -1 4 5}
move car 1 to empty spot(denoted as -1) will make it {-1,2,3,1,4,5}
push 1 to the output list because you move car 1 to the empty spot

suppose you have a initial order {1 2 3 -1 4 5} and a final order {5,1,-1,3,2,4}, you need to transfer {1 2 3 -1 4 5} to {5,1,-1,3,2,4}, push each car moved into a output list.
- wtcupup2017 December 28, 2016 in United States | Report Duplicate | Flag  ".

2. Data Structure and Algorithm
Let's start from the simple cases. "-1" represents the empty space and "A, B, C, ......" represents the location of cars.
    - One car
        Desired position:
            (-1, A)
        Initial position:
            1. (A, -1) - 1 swap
    - Two cars
        Desired position:
            (-1, A, B)
        Initial position:
            1. (A, B, -1)
                - all 3 out of position, then 2 swaps
            2. (B, A, -1)
                - A is at the same position, then become "One car" case and need 1 swap
            3. (A, -1, B)
                - B is at the same position, then become "One car" case and need 1 swap
            4. (B, -1, A)
                - all 3 out of position, then 2 swaps
            5. (-1, B, A)
                - -1 is at the same position
                - swapping -1 with B becomes Case 4
                - 1 + 2 = 3 swaps
    - Three cars
        Desired position:
            (-1, A, B, C)
        Initial position:
            1. (A, B, C, -1)
                - all 4 out of position - 3 swaps
            2. (A, C, B, -1)
                - all 4 out of position - 3 swaps
            3. (B, A, C, -1)
                - A is at the same position and become "Two cars" case - 2 swaps
            4. (B, C, A, -1)
                - all 4 out of position - 3 swaps

            5. (C, A, B, -1)
                - Both A and B are at the same position, become "One car" case - 1 swap
            6. (C, B, A, -1)
                - all 4 out of position - 3 swaps

            7. (A, B, -1, C)
                - C is at the same position and become "Two cars" case - 2 swap
            8. (A, C, -1, B)
                - all 4 out of position - 3 swaps

            9. (B, A, -1, C)
                - A and C are at the same position and become "One car" case - 1 swap
            10. (B, C, -1, A)
                - all 4 out of position - 3 swaps

            11. (C, A, -1, B)
                - A is at the same position and become "Two cars" case - 2 swaps
            12. (C, B, -1, A)
                - all 4 out of position - 3 swaps

            13. (A, -1, B, C)
                - B and C are at the same position and become "One car" case - 1 swap
            14. (A, -1, C, B)
                - all 4 out of position - 3 swaps

            15. (B, -1, A, C)
                - C is at the same position and become "Two cars" case - 2 swap
            16. (B, -1, C, A)
                - all 4 out of position - 3 swaps

            17. (C, -1, A, B)
                - all 4 out of position - 3 swaps

            18. (C, -1, B, A)
                - B is a the same position then become "Two cars" case - 2 swaps
            19. (-1, A, C, B)
                - A is at the same position, then becomes "Two car" case 5
                - 3 swaps
            20. (-1, B, A, C)
                - C is at the same position, then becomes "Two car" case 5
                - 3 swaps
            21. (-1, B, C, A)
                - Swapping -1 and B becomes case 16
                - 1 + 3 = 4 swaps
            22. (-1, C, A, B)
                - Swapping -1 and C becomes case 17
                - 1 + 3 = 4 swaps
            23. (-1, C, B, A)
                - B is at the same position, then becomes "Two car" case 5
                - 3 swaps

Here is the conclusion to make:
1.If cars and empty space are not at the same position, then N cars needs N swaps to reach the desired position.
2. If empty space is at the same position but all cars are not, then N cars needs N+1 swaps to reach the desired position.
3. If there are cars at the same position, then remove them and reduce N to M. And take the case as of in 1 or 2.

Pseudo-code:
1. Remove all the cars at the same position between initial position and desired position
2. N as the all cars and M as after removing the cars at the same positions
    - return M if -1 is not at the same position
    - return M + 1 if -1 is at the same position. */
	
	
public class array_minimum_moves_manipulating {

	static int  count=0;
	static int c=0;
	public static ArrayList<Integer> moves(ArrayList<Integer> init,ArrayList<Integer> finl){
	    //c=c+1;   
		if(init.equals(finl)) return init;
	        else if(init.indexOf(-1)==finl.indexOf(-1)){
	        	//System.out.println(22);
	        	int n=0;
	        	while(init.get(n)==finl.get(n) ) n++;
	        	
	        init=	swap(init,init.indexOf(-1),n);
	        	
	        return moves(init,finl);
	        
	        }
	        	
	        else{
	            	
	             int one=init.indexOf(-1);
		        	
	     	       int f=finl.get(one);
	     	       
	     	       int two=init.indexOf(f);
	                /*System.out.println("Moving index "+i+" to index "+ curr_empty_space);
	                init = swap(init,i,curr_empty_space);
	                System.out.println("Moving index "+indx+" to index "+ i);
	                init = swap(init,indx,i);*/
	     	       
	     	       init=swap(init,one,two);
	     	   return   moves(init, finl);
	     	       
	            }
	      

	        

	    }

	  
	public static ArrayList<Integer> swap(ArrayList<Integer> list,int pos_a, int pos_b){
            count=count+1;
	        int tmp = list.get(pos_a);
	        list.set(pos_a,list.get(pos_b));
	        list.set(pos_b,tmp);

	        return list;
	    }

	    public static void main(String[] args){
	        Integer[] pos = new Integer[] {-1,1,3,4};
	        ArrayList<Integer> init = new ArrayList<Integer>();
	        ArrayList<Integer> finl = new ArrayList<Integer>();
	        init.addAll(Arrays.asList(pos));
	        pos = null;
	        pos = new Integer[] {-1,3,4,1};
	        finl.addAll(Arrays.asList(pos));
	       
	       init= moves(init,finl);
	       System.out.println(init); 
	       
	        System.out.println(count);
	        //int[] s = new int[] {1,2,3,-1,4,5};
	        //int[] f = new int[] {2,5,-1,3,1,4};
	        //int[] s=new int[] {2,1,4,3,-1};
	        //int [] f=new int []{1,2,3,4,-1};
	        //System.out.println(flipToB(s,f));
	    }


	
static int flipToB(int curr[], int exp[]) {
int space = -1;
int spaceIdx = 0;
int swap = 0;
Map<Integer, Integer> ktv = new HashMap<>();
for (int i = 0; i < curr.length; i++) {
    ktv.put(curr[i], i);
    if (exp[i] == space) {
        spaceIdx = i;
    }
}

for (int i = 0; i < curr.length; i++) {

    if (exp[i] == curr[i])
        continue;

    int pos = i;
    move(i, ktv.get(space), ktv, curr);
    swap = swap + 1;
    while (pos != spaceIdx) {
        int newpos = ktv.get(exp[pos]);
        move(newpos, pos, ktv, curr);
        pos = newpos;
        swap = swap + 1;
    }

}
return swap;
}

static void move(int fromIdx, int toIdx, Map<Integer, Integer> ktv, int input[]) {
int val = input[fromIdx];
input[fromIdx] = input[toIdx];
ktv.put(input[toIdx], fromIdx);
input[toIdx] = val;
ktv.put(val, toIdx);
}



}