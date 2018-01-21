package Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class hacakaerank {
	

	static String richieRich(String l, int n, int k, int start, int end){
		
		if(k<=0 && start<end && (l.charAt(start)!=l.charAt(end))){
			return  "-1";
		}
		else if(start>=end && n%2==0 ){
			
			return l;
		}
		else if(start>=end && k>=1){
			return l.substring(0,start)+"9"+l.substring(start+1);
		}
		else if(start>=end){
			return l;
		}
		else if(l.charAt(start)==l.charAt(end)){
			 
			String a=richieRich( l, n, k, start+1, end-1);
			String b="";
			if(l.charAt(start)!='9'){
				if(k>=2){
			 
					 b=richieRich(l.substring(0,start)+"9"+l.substring(start+1,end)+"9"+l.substring(end+1), n, k-2, start+1, end-1);
					
				}
				
			}
			if(b!="-1"){
				return b;
			}
			else return a;
		}
		else if(l.charAt(start)!=l.charAt(end)){
			
			String a="";
			String b="";
			String c="";
			if(l.charAt(start)=='9'|| l.charAt(end)=='9'){
			if(k>=1 && l.charAt(start)>l.charAt(end)){
			  a=richieRich(l.substring(0,end)+l.charAt(start)+l.substring(end+1), n, k-1, start+1, end-1);
			}
			else{
				b= richieRich(l.substring(0,start)+l.charAt(end)+l.substring(start+1), n, k-1, start+1, end-1);
				}
			if(a!="-1"){
				return a;
				
			}
			else{
				return b;
			}
			
			}
			else{
				if(k>=1 && l.charAt(start)>l.charAt(end)){
					  a=richieRich(l.substring(0,end)+l.charAt(start)+l.substring(end+1), n, k-1, start+1, end-1);
					}
					if(k>=1 && l.charAt(start)<l.charAt(end)){
						b= richieRich(l.substring(0,start)+l.charAt(end)+l.substring(start+1), n, k-1, start+1, end-1);
						}
				
			if(k>=2){
			
				c=richieRich(l.substring(0,start)+"9"+l.substring(start+1,end)+"9"+l.substring(end+1), n, k-2, start+1, end-1);
				
			}
			if(c!="-1"){
				return c;
			}
			else if(a!="-1"){
				return a;
			}
			else{
				return b;
			}
			
			}
			
			
		}
		else	return l;
		
		
		
	}
	
	
/*
	    static String richieRich(String l, int n, int k){
	        // Complete this function
	        
	        int p=0;
	         String firsthalf="";
	            String secondhalf="";
	        if(n%2==0){
	     
	            firsthalf=l.substring(0,n/2);
	            secondhalf=l.substring(n/2);
	        }
	        else{
	           firsthalf=l.substring(0,n/2);
	            secondhalf=l.substring((n/2)+1);
	        }
	        int t=0;
	        System.out.println(firsthalf.length());
	        System.out.println(secondhalf.length());
	        int f=0;
	        int s=secondhalf.length()-1;
	      while(p<=k && f<firsthalf.length()&& s>=0){
	          if(firsthalf.charAt(f)=='9' && secondhalf.charAt(s)=='9'){
	              
	          }
	          else if(firsthalf.charAt(f)=='9'&& secondhalf.charAt(s)!='9'){
	              if(k-p>=1){

	            	  secondhalf=   secondhalf.substring(0,s)+"9"+secondhalf.substring(s+1);
	                  p++;
	              }
	              else{
	                 return "-1";
	              }
	          }
	          else if(firsthalf.charAt(f)!='9'&& secondhalf.charAt(s)=='9'){
	              if(k-p>=1){
	               firsthalf= firsthalf.substring(0,f)  +"9"+ firsthalf.substring(f+1);
	                  p++;
	              }
	              else{
	                  return "-1";
	              }
	          }
	          else if(firsthalf.charAt(f)!=secondhalf.charAt(s)){
	              if(k-p>=2){
	            firsthalf=firsthalf.substring(0,f)  +"9"+ firsthalf.substring(f+1);
	             secondhalf= secondhalf.substring(0,s)+"9"+secondhalf.substring(s+1);
	                   p=p+2;
	              }
	              else if(k-p>=1){
	            	  if(firsthalf.charAt(f)>secondhalf.charAt(s)){
	            	 
	 	             secondhalf= secondhalf.substring(0,s)+firsthalf.charAt(f)+secondhalf.substring(s+1);
	 	                   p=p+1;}
	            	  else{
	            		  firsthalf=firsthalf.substring(0,f)  +secondhalf.charAt(s)+ firsthalf.substring(f+1);
	            		  p=p+1;
	            	  }
	              }
	             else{
	                   return "-1";
	             }
	          }
	          else {
	              if(k-p>=2){
	                  firsthalf=firsthalf.substring(0,f)  +"9"+ firsthalf.substring(f+1);
	             secondhalf= secondhalf.substring(0,s)+"9"+secondhalf.substring(s+1);
	                   p=p+2;
	              }
	              
	              
	             
	          }
	          f++;
              s--;
	          
	      }
	       
	       if(n%2==0){
	           return firsthalf+secondhalf;
	       }
	        else if(k-p>=1){
	           return firsthalf+"9"+secondhalf; 
	        }
	        else{
	            return firsthalf+l.charAt(n/2)+secondhalf;
	        }
	    }
*/
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        /*int n = in.nextInt();
	        int k = in.nextInt();
	        String s = in.next();*/
	        
	        
	        
	        int n=6;
	        int k =3;
	        String s ="092282";
	        String line=null;
	        String result = richieRich(s, n, k,0,n-1);
	        System.out.println(result);
	      /*  try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader("C:\\Users\\saiku\\Java\\Google\\Strings\\Strings\\test.txt");

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);

	            int i=0;
	            while((line = bufferedReader.readLine()) != null) {
	              if(i==0){
	            	String v[]=line.split(" ");
	               n=Integer.parseInt(v[0]);
	               k=Integer.parseInt(v[1]);
	               i++;
	              }
	              else{
	            	  s=s+line;
	              }
	              
	            }   

	            // Always close files.
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                 "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" +
	                 "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	    
	    
	    
	    String result = richieRich(s, n, k,0,n-1);
        //System.out.println(result);
	    try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter("C:\\Users\\saiku\\Java\\Google\\Strings\\Strings\\out.txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(result);
           
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    */
	        
	    }
	

}
