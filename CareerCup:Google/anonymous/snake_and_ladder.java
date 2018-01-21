import java.util.LinkedList;
import java.util.Queue;

//snake and ladder game
//http://www.geeksforgeeks.org/snake-ladder-problem-2/
//Design an optimised algorithm to solve snakes and ladders with the least amount of roles 
//possible under the assumption that you get whatever role you want when you role the dice.
public class snake_and_ladder {
	//Each cell has a value like its distance from source
		//and its position
	 static class cell{
		int position;
		int distance;
		
		}
	public static void main(String[] args){
		// Let us construct the board given in above diagram
		int N = 30;
	    //N represents the no of cells in the baord
	    int board[]=new int[30];
	    for (int i = 0; i<N; i++)
	        board[i] = -1;
	 //-1 represent no snake or ladder in the cell
	    
	    // Ladders
	    board[2] = 21;
	    board[4] = 7;
	    board[10] = 25;
	    board[19] = 28;
	    board[21] = 27;
	    // Snakes
	    board[26] = 0;
	    board[25] = 0;
	    board[20] = 8;
	    board[16] = 3;
	    board[18] = 6;
	    Queue<cell> q=new LinkedList<cell>();
		
		
	   
	    
	    System.out.println( BFS(board,N, q));
	}
	
	
	
static 	 int BFS(int []board,int N,Queue<cell> q){
		//if there is a ladder at the first position
		cell c=new cell();
		c.position=0;
		c.distance=0;
		q.add(c);
	    boolean visited[]=new boolean[N];
		while(!q.isEmpty()){
			cell c1=q.poll();
			if(c1.position==N-1){
				return c1.distance;
			}
			if(!visited[c1.position]){
				visited[c1.position]=true;
			
			for(int i=c1.position; i<(c1.position+6)&& i<30;i++){
				if(!visited[i]){
				cell c2=new cell();
				
				if(board[i]!=-1){
					int pos=i;
			     while(board[pos]!=-1){
			    	
			    	c2.position=board[pos];
			    	c2.distance=c1.distance+1;
			    	pos=board[pos];
			    	
			    }}
			    else {
			    	c2.position=i;
			    	c2.distance=c1.distance+1;
			    }
			    q.add(c2);
			}
				}
		}
		}
		return -1;
		
		
		
	}
	
}
