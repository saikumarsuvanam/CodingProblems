/*Given a sequence of words, and a limit on the number of characters that can be put in one 
line (line width). Put line breaks in the given sequence such that the lines are printed 
neatly. Assume that the length of each word is smaller than the line width.
The word processors like MS Word do task of placing line breaks. The idea is to have 
balanced lines. In other words, not have few lines with lots of extra spaces and some lines with small 
amount of extra spaces.
http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
The greedy solution is to place as many words as possible in the first line. 
Then do the same thing for the second line and so on until all words are placed. 
This solution gives optimal solution for many cases, but doesn’t give optimal solution 
in all cases. For example, consider the following string “aaa bb cc ddddd” and 
line width as 6. Greedy method will produce following output.
aaa bb 
cc 
ddddd
Extra spaces in the above 3 lines are 0, 4 and 1 respectively. 
So total cost is 0 + 64 + 1 = 65.
But the above solution is not the best solution. 
Following arrangement has more balanced spaces. Therefore less value of total cost function.
aaa
bb cc
ddddd
Extra spaces in the above 3 lines are 3, 1 and 1 respectively. 
So total cost is 27 + 1 + 1 = 29.
*/
import java.util.*;
public class word_wrap_problem {
           public static void main(String[] args){
        	   String input="aaa bb cc ddddd";
        	   int line_width=6;
        	   String[] words=input.split(" ");
        	   find(words,line_width,0,"",0);
        	   System.out.println(mincost);
           }
           static HashMap h=new HashMap();
           static int mincost=Integer.MAX_VALUE;
           static void find(String[] words,int linewidth,int currentindex,String line,int globalcost){
        	   int cost=0;
        	   if(mincost>globalcost&& currentindex>=words.length){
 		    	  mincost=globalcost;
 		      }	
        	   
        	   else{
        		   for(int i=currentindex; i<words.length;i++){
        	   
        		      if((line+words[i]).length()<=linewidth){
        			  line=line+words[i]+" ";
        			  
        			  cost=linewidth-(line.length()-1);
        			  
        			  globalcost=globalcost+(cost*cost*cost);
        			  find(words,linewidth,i+1,"",globalcost);
        			  globalcost=globalcost-(cost*cost*cost);
         			  }
        			 
        		      else {find(words,linewidth,i,"",globalcost);
        		      
        		      
        		      }
        	  }
        	   }
        		      
        	      
                     																						
                	 
                	  
        	   }           

	
	
           }

