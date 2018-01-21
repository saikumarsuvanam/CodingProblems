/*

Given an NxN grid with an array of lamp coordinates. 
Each lamp provides illumination to every square on their x axis, 
every square on their y axis, and every square that lies in their diagonal 
(think of a Queen in chess). Given an array of query coordinates, determine whether 
that point is illuminated or not. The catch is when checking a query all lamps adjacent 
to, or on,…
*/

//without kknowing grid size we are justing saving the lamps locations in row/
//column and diaagonal wise and checking about the query.
import java.util.*;
public class checking_n_a_grid_whether_given_point_is_illuminated_or_not_bya_lamp {

	ArrayList columns=new ArrayList();
	ArrayList rows=new ArrayList();
	ArrayList diagonalsLeft=new ArrayList();
	ArrayList diagonalsRight=new ArrayList();;
	public static void main(String[] args){
		checking_n_a_grid_whether_given_point_is_illuminated_or_not_bya_lamp t=new checking_n_a_grid_whether_given_point_is_illuminated_or_not_bya_lamp();
		//pass 2d array as lamps 
		
		
	//    t.insertLamps(lamps);
	}
	

	public  void  insertLamps(int[][] lamps){
		

		
		for(int[] lampcoor : lamps){
			int x = lampcoor[0];
			int y = lampcoor[1];

			columns.add(y);
			rows.add(x);
			diagonalsLeft.add(x+y);
			diagonalsRight.add(x - y);
		}
	}

	public boolean query(int x, int y){
		if(columns.contains(x) || rows.contains(y) || diagonalsLeft.contains(x+ y) || diagonalsRight.contains(x-y))
			return true;
	

		else return false;

}
	/* python method
	lamps = [(0,0), (2,3), (1,5)]
			rows = set([i for i, j in lamps])
			cols = set([j for i,j in lamps])
			pos_diags = set([i + j for i,j in lamps])
			neg_diags = set([i - j for i,j in lamps])

			points = [(1,1), (8,1), (5,6), (8,9), (9,8)]
			for i, j in points:
			    if i in rows: print True
			    elif j in cols: print True
			    elif i + j in pos_diags: print True
			    elif i - j in neg_diags: print True
			    else: print False
			    */	
}
	

