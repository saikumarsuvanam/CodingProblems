package Math;

import java.util.*;

/*Given a equation in the form of "3x+4y+2=-5y+2x+10", simplify the 
equation to be in form "y=Ax+B", and return A,B. Also allow parenthesis 
to be in the equation. Ex. "3y-4x+(3-(2x-3y))=10y", result is "y =0.75 - 1.5x"
*/
public class write_an_equation_of_form_y_ax_plus_b_form {

	public static void main(String[] args){
		//String equation="3y-4x+(3-(2x-3y))=10y";
		String equation="3y-4x+(3-(2x-3y))=10y";
		//String equation="1y=2+34x+2y+(12-4)";
		String[] equations1=equation.split("[=]");
		if(equations1.length==2){
			HashMap<Character,Integer> leftmap=new HashMap<Character,Integer>();
		HashMap<Character,Integer> rightmap=new HashMap<Character,Integer>();
		remove_parenthesis(equations1[0],leftmap);
		int leftconstant=constant;
		constant=0;
		
		remove_parenthesis(equations1[1],rightmap);
		int rightconstant=constant;
		
		  Integer y1 =leftmap.get('y');
		  Integer y=y1;
		  
		  Integer y2=rightmap.get('y');
		  if(y2!=null)
		  y=y1-y2;
		  Integer x1=leftmap.get('x');
		  Integer x=x1;
		  if(x1!=null)
		  x=x1;  
		  Integer x2=rightmap.get('x');
		 if(x2!=null&&x1!=null){
		   x=x1-x2;}
		 if(x1==null && x2!=null)
			 x=-x2;
		 Integer constnt=-rightconstant;
		 if(leftconstant!=0){
		 constnt= leftconstant-rightconstant;}
		  String form="";
		   if(constnt>0){
			   x=-x;
			   constnt=-constnt;
		  form= y.toString()+"y"+"="+x.toString()+"x"+constnt;}
		   else {
			   x=-x;
			   constnt=-constnt;
			   form= y.toString()+"y"+"="+x.toString()+"x"+"+"+constnt;
		   }
		 System.out.println(form);
		
		
		}
		
		
	}
	
	static int constant=0;
	
	static void remove_parenthesis(String equation,HashMap<Character,Integer> h){
		Stack s=new Stack();
		
		String[] equations=equation.split("(?<=[-+*/()])|(?=[-+*/()])");
		System.out.println(equations);
		
		
	
		StringBuilder result=new StringBuilder();
		
		String	beforesymbol="";
		for(int i=0; i<equations.length;i++){ 
			boolean x = false;
		try { 
	        Integer.parseInt(equations[i]); 
	    } catch(NumberFormatException e) { 
	        x=true; }
			
			if(equations[i].equals("-")){
			
				 beforesymbol="negative";
			}
			else if(equations[i].equals("+")){
				
				 beforesymbol="positive";
				
			}
			 
			else if(x &&
					
					
					equations[i].length()>=2){
				String number=equations[i].substring(0,equations[i].length()-1)+"";
				Character variable=equations[i].charAt(equations[i].length()-1);
				if(beforesymbol=="negative"){
					if(h.containsKey(variable)){
						
						h.put(variable,-Integer.parseInt(number)+h.get(variable));
					}
					else 	h.put(variable,-Integer.parseInt(number));
				
				 
				}
				else {
					if(h.containsKey(variable)){
						
						h.put(variable,Integer.parseInt(number)+h.get(variable));
					}
					else h.put(variable,Integer.parseInt(number));
					
				}
				
				
			}
			else if(equations[i].equals("(")){
				int count=1;
		      i=in_to_stack(beforesymbol,equations,i+1,h,count);
			}
			
			
			
			else{
				String number= equations[i];
				if(beforesymbol.equals("negative")){
				constant=constant-Integer.parseInt(number);}
				else constant=constant+Integer.parseInt(number);
			}
			
	     
			
		}
		   
		
	}
	static int in_to_stack(String beforesymbol,String equations[],int start,HashMap<Character,Integer> h,int count){
		boolean x = false;
		try { 
	        Integer.parseInt(equations[start]); 
	    } catch(NumberFormatException e) { 
	        x=true; }
		
		int y=0;
		for(int i=start; i<equations.length;i++){
    	if(equations[i].equals("-")){
			if(beforesymbol=="negative")
			beforesymbol="positive";
			else beforesymbol="negative";
		}
    	
    	else if(equations[i].equals("+")){
			if(beforesymbol=="negative")
		beforesymbol="negative";
			else beforesymbol="positive";
			
		}
    	else if(x &&
				
				
				equations[i].length()>=2){
			String number=equations[i].charAt(0)+"";
			Character variable=equations[i].charAt(1);
			if(beforesymbol=="negative"){
				if(h.containsKey(variable)){
				
					h.put(variable,-Integer.parseInt(number)+h.get(variable));
				}
				else 	h.put(variable,-Integer.parseInt(number));
			
			}
			else {
				if(h.containsKey(variable)){
					
					h.put(variable,Integer.parseInt(number)+h.get(variable));
				}
				else 	h.put(variable,Integer.parseInt(number));
		}
    	}
    	else if(equations[i].equals(")")){
    		count--;
    		if(count==0){
    			y=i;
    			return i;
    		}
    		
    	}
    
    	else if(equations[i].equals("(")){
    		count++;
		    return in_to_stack(beforesymbol,equations,i+1,h,count);
			}
    	else{
			String number= equations[i];
			if(beforesymbol.equals("negative")){
			constant=constant-Integer.parseInt(number);}
			else constant=constant+Integer.parseInt(number);
		}
			
    }
   return y;
	}
}
	
