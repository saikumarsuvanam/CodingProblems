import java.util.ArrayList;
import java.util.*;

public class grid {

	public static void main(String[] args){
		
		
	char	[][]grid=new char[6][6];
		
	for(int i=0; i<grid.length; i++){
		for(int j=0; j<grid.length; j++){
			
			grid[i][j]='e';
			
		}
		
		
	}
	
	grid[2][5]='h';
	grid[3][2]='h';
	grid[4][2]='h';
	
int []	housesrow={2,3,4};
int [] housescolumn={5,2,2};
	
	
	
	grid[2][3]='#';
	grid[4][5]='#';
	grid[3][4]='#';
	grid[3][5]='#';
	grid[2][4]='#';
	
	
	
	boolean visited[][]=new boolean[6][6];
	for(int i=0; i<6; i++){
		for(int j=0; j<6; j++){
			
			visited[i][j]=false;
		}
		
	}
	
	int sum=0;
	int finaldistance=9999999;
int 	stpoint=0;
int enpoint=0;
for(int i=0; i<grid.length; i++){	
	
	for(int j=0; j<grid[0].length; j++){
		
       for(int l=0; l<housesrow.length; l++){	
    	   
    	  sum += findoptimal(grid,2,2,5,5,0,999999999,visited);
    	   
    	   System.out.println(sum);
       }
	
		if(sum <finaldistance){
			
			finaldistance=sum;
			stpoint=i;
			enpoint=j;
			
		}
       
       
	}
	
	
	
}
	
System.out.println(finaldistance);
System.out.println(stpoint);
System.out.println(enpoint);
		//System.out.println(result.size());
		for(int i=0; i<6; i++){
			for(int j=0; j<6; j++){
				
				if(visited[i][j]==true){
					//System.out.println(i+" and "+j);
					
				}
			}
			
		}
		
	}
	
	static ArrayList<Integer> result=new ArrayList<Integer>();
	
static int findoptimal(char[][]grid, int x1, int y1,int x2,int y2,int distance,int mindistance,boolean[][]visited){
	

	if(x1==x2&&y1==y2){
		//System.out.println(distance);
		 return 0;
		 
		
	}
	
	
	else{
		Queue<int []> q=new LinkedList<int []>();
		int []temp1={x1,y1,0};
	
		
		 q.add(temp1);
		
		while (!q.isEmpty())
		{
			
		int[]curr=q.poll();
	      x1=curr[0];
	      y1=curr[1];
			if(x1+1<6){
	if(!visited[x1+1][y1]&& grid[x1+1][y1]!='#'&& (x1+1)<6){
		int [] temp={x1+1,y1,curr[2]+1};
		//System.out.println(curr[2]+1);
		if(x1+1==x2 && y1==y2)return curr[2]+1;
		visited[x1+1][y1]=true;
		 q.add(temp);
	}
		
		
  //findoptimal(grid, x1+1, y1,x2,y2,distance+1,mindistance,visited);
  }
	if(x1-1>=0){
	if(!visited[x1-1][y1]&& grid[x1-1][y1]!='#'&& (x1-1)>=0){
		int []temp={x1-1,y1,curr[2]+1};
		visited[x1-1][y1]=true;
		if(x1-1==x2 && y1==y2)return curr[2]+1;
		 q.add(temp);
	
//findoptimal(grid, x1-1, y1,x2,y2,distance+1,mindistance,visited);
		}}
	if(y1+1<6){
	if(!visited[x1][y1+1]&& grid[x1][y1+1]!='#'&& (y1+1)<6){
		
		int []temp={x1,y1+1,curr[2]+1};
		if(x1==x2 && y1+1==y2)return curr[2]+1;
		visited[x1][y1+1]=true;
		 q.add(temp);

		}}
	if(y1-1>=0){
	if(!visited[x1][y1-1]&& grid[x1][y1-1]!='#'&& (y1-1)>=0){
		int []temp={x1,y1-1,curr[2]+1};
		if(x1==x2 && y1-1==y2)return curr[2]+1;
		visited[x1][y1-1]=true;
		 q.add(temp);

		}}
	
	
	
	}
		
return 0;		
		
}
}
}
	

