
	import java.util.*;
public class pivot_index_such_that_sumof_nnumbers_on_left_equal_to_right {

public static void main(String[] args) {
	        int a [] ={1,2,3,4,0,6};
	        int leftsum=0;
	        
	        int rightsum=0;
	        int lindex=0;
	        int rindex=a.length-1;
	        while(lindex<rindex){
	            if(leftsum<rightsum){
	            leftsum=leftsum+a[lindex];
	             lindex++;}
	            else{
	            rightsum=rightsum+a[rindex];
	            rindex--;   
	            }
	        }
	        System.out.println("pivot index is"+":"+lindex);
	    }
	}    
	   



