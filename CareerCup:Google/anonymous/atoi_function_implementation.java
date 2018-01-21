/*itoa function converts integer into null-terminated string. It can convert negative numbers too. 
The standard definition of itoa function is give below:-*/
public class atoi_function_implementation {

	public static void main(String[] args) {
        
    	   StringBuilder sb=new StringBuilder();
    	
    	System.out.println(integerconvert(-8,sb,2));   
      
    
    	
       
    }
	
	static String integerconvert(int number,StringBuilder sb,int base){
		
		if(number==0){
			
			sb.append(0);
		return sb.toString();
		}
		Boolean isnegative=false;
		if(number <0){
			isnegative=true;
		number=-number;	
		}
		
		
		while(number !=0){
		
		int rem=number%base;
		
		if(rem<=9){
			
			sb.append(rem);
		}
		else{
			char a='A';
	    	a=(char)(a+rem-10);
			sb.append(a);
		}

			number=number/base;
		}
		
		sb.reverse();
		if(isnegative){
			
			sb.insert(0, '-');
		}
		return sb.toString();
			
			
			
		}
		
		
		
		
		
		
	}
	

