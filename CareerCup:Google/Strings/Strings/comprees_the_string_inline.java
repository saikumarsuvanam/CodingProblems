package Strings;

public class comprees_the_string_inline {

	public static void main(String[] args) {
		
	      
		
		String a = "abbc";


        for(int i=0;i<a.length();i++){
       
            int c=i+1;
            int duplicateCharCount=1;
           
            while(c<a.length()&&a.charAt(c)==a.charAt(i)){
                ++c;
                ++duplicateCharCount;
            }

                a=a.substring(0,i+1)+duplicateCharCount+a.substring(i+duplicateCharCount);
                i++;


        }
        System.out.println(a);
		
	}
	
}
