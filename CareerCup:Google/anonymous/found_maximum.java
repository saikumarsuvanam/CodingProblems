import java.util.PriorityQueue;

public class found_maximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] a={4,3,2,5,1,1};
       int[]b={-1,3,-2};
       System.out.println(diff(b));
	}
	
	static int diff(int[] a){
		int max=Integer.MIN_VALUE;
		for(int i=0; i<a.length;i++){
			int one=findmax(a,0,i);
			if(i+1<a.length){
		    int two=findmax(a,i+1,a.length-1);
			int gmax=Math.abs(one-two);
			if(gmax>max){
				max=gmax;
			}
		}
			else return max;
			
		}
		return max;
	}
	static int  findmax(int[]a, int start,int end){
		int max=Integer.MIN_VALUE;
	
		for(int i=start; i<=end;i++){
			if(a[i]>max){
				max=a[i];
				
			}
			
		}
		return max ;
		
	}

}
