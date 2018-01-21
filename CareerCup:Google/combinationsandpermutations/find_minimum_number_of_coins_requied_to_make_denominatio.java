

public class find_minimum_number_of_coins_requied_to_make_denominatio {

	public static void main(String[] args) {
		int[] arr=new int[]{9, 6, 5, 1};
		int n=11;
		System.out.println(make_few_changes(arr,  n));
	}
	
	static int make_few_changes(int []a, int n){
		
	if(n<=0){
		return 0;
	}
	int min=Integer.MAX_VALUE;
		for(int i=0; i<a.length;i++){
			int sum=1+make_few_changes(a,n-a[i]);
			if(sum<min){
				min=sum;
			}
		}
		return min;
	}
}
