import java.util.HashSet;
//for labelled nodes
public class find_number_of_binary_tree_possible_for_n_nodes {

	public static void main(String[] args) {
		
		System.out.println(find(20));
	    
	}
	static int find_ncr(int n, int r) {
		   int result;
		 
		   result = factorial(n)/(factorial(r)*factorial(n-r));
		 
		   return result;
		}
	static int factorial(int n) {
		   int c;
		  int result = 1;
		 
		   for (c = 1; c <= n; c++)
		      result = result*c;
		 
		   return result;
		}
	
	
	
	
	static int  find(int n){
if(n<=1)return 1;
         int sum=0;
         
		  int res=0;
		  for(int j=0;j<=(n-1);j++){
        		   int a=find(j);
        		   int b=find(n-j-1);
        		        res=res+find_ncr(n-1,j)*a*b;
        	}
        	sum=sum+n*res;
        
	 
		return sum;
		
	}
	
}

