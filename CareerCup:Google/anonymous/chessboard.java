
public class chessboard {

	public static void main(String[] args){
		

		
		
		
	System.out.println(getwaystoarrangechessboard(8,-1));
	}
	
	static int ways=0;
	
static 	int getwaystoarrangechessboard(int n,int j){
		
	if(n==1 || j==n) return 1;
	
	
	
	else {for(int i=1; i<=n; i++){
		
		
		if(j!=i&&i-1!=j)
ways =ways+getwaystoarrangechessboard(n-1, i);
		
		
		
	}
	return ways;
		
		
	}
}
	
}
