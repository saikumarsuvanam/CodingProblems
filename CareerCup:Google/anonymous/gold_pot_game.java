import java.util.Arrays;
import java.util.HashMap;
//http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
/* google-interview-questions
Question: Two players A and B are playing a game. Pots of gold, each with
varying number of coins are placed in a single line. The rules of the game are:
1) Players play turn by turn.
2) On each turn a player can pick a pot of gold from either end of the line. He
gets all the gold in that pot. The next pot of gold on that end is now available
for picking.
What is the maximum number of gold can the first player get ?*/

public class gold_pot_game {
	class players{
		int player1;
		int player2;
	 players(int profit1,int profit2){
			this.player1=profit1;
			this.player2=profit2;
		}
	}
	//competetive game-if second player does not cooperate with the first player-both play good
		public  players competetive_game(int[] arr,int start,int end,int whowillstart,HashMap<String,players> hmap){
		if(hmap.containsKey(start+","+end)){
				return hmap.get(start+","+end);
			}
		    players p =new players(0,0);
			if(start<=end){
			if(whowillstart==1){
				players option1=competetive_game(arr,start+1,end,2, hmap);
				players option2=competetive_game(arr,start,end-1,2, hmap);
				
				if(arr[start]+option1.player1>arr[end]+option2.player1){
					p=new players(option1.player1+arr[start],option1.player2);
				}
				else p=new players(option2.player1+arr[end],option2.player2);;
				
			}
			else{
				if(arr[start]>arr[end]){
					
					players p1=competetive_game(arr,start+1,end,1, hmap);
					p=new players(p1.player1,p1.player2+arr[start]);
				}
				else  {players p1=competetive_game(arr,start,end-1,1, hmap);
				p=new players(p1.player1,p1.player2+arr[end]);	
				}
			}}
			else return p;
			
			if(!hmap.containsKey(start+","+end)){
				hmap.put(start+","+end, p);
			}
			
			return p;
			
		}
		
	//coperative method-like if second player coperates with first player	
	public static int find(int[] ar,int start,int end,int whowillstart){
		
		int max=0;
		if(start<=end){
		if(whowillstart==1){
			if(ar[start]>ar[end]){
			 max=ar[start]+find(ar,start+1,end,2);	
			}
			else  max=ar[end]+find(ar,start,end-1,2);
			}
		
		else if(whowillstart==2){
			if(ar[start]>ar[end]){
				max=find(ar,start,end-1,1);
			}
			else max=find(ar,start+1,end,1);	
		}
		}
		return max;
	}
	public static void main(String[]args){
	
		int[] ar=new int[]{20, 30, 2, 2, 2, 10};
		int whowillstart=1;
		
		HashMap hmap=new HashMap();
		gold_pot_game g=new gold_pot_game();
	   players p=g.competetive_game(ar,0,ar.length-1, whowillstart,hmap);
		System.out.println("In Competetive game, Max profit for player 1 "+"is "+p.player1+" and "+"Max profit for player 2 is "+p.player2);
		System.out.println("In Co-operative game, max profit  for player 1 is "+find(ar,0,ar.length-1, whowillstart));

	}
}


