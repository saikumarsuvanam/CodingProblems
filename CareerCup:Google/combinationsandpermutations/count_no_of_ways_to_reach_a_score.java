//http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
/*Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, 
 * find number of ways to reach the given score.
 */
public class count_no_of_ways_to_reach_a_score {
public static void main(String[] args){
	int n = 5;

	
	System.out.println(count(n));
	}

	static int count(int n)
	{
		// table[i] will store count of solutions for
		// value i.
		int []table=new int[n+1];


		

		// Base case (If given value is 0)
		table[0] = 1;

		// One by one consider given 3 moves and update the table[]
		// values after the index greater than or equal to the
		// value of the picked move
		for (int i=1; i<=n; i++)
		table[i] += table[i-1];
		for (int  i=2; i<=n; i++)
		table[i] += table[i-2];
		for (int i=3; i<=n; i++)
		table[i] += table[i-3];

		return table[n];
	}


	// Driver program
	
		
		

		
	


}
