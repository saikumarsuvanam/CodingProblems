
public class kickstartcodejam {

	
	
	public static void main(String[] args) {
	int m=2;
	int n=2;
	ordered(3,2,0,0,false);
	//factorial(m+n);
	
	System.out.println(invalid);
	System.out.println(count);
	
	
}
	
	
	static int count=0;
	static int invalid=0;
	static void ordered(int m, int n,int a, int b,boolean isvalid){
		if(a<=b&&b!=0&&a!=0){
        	isvalid=true;}
		
		
	if(a==m&&b==n)
	 invalid++;
	
	        
	       
		if(a==m&&b==n&&!isvalid){
		    count++;
		    isvalid=false;
		}
		
		
		
		for(int start=1;start<3;start++){
			if(start==1){
				if(a+1<=m)
			ordered(m,n,a+1,b,isvalid);}
		
			if(start==2)
				if(b+1<=n)
			ordered(m,n,a,b+1,isvalid);
				
			}
		
		
		
	}
	
	
}
	

