package Hard;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static List<String> getLongestSequence(List<String> userA, List<String> userB) {
		    // IMPLEMENTATION GOES HERE
		    
		    List<String> res=new ArrayList<String>();
		    int lcs[][]=new int [userA.size()+1][userB.size()+1];
		    int longest=0;
		    int lrow=0;
		    int lcol=0;
		    for(int i=0;i<=userA.size();i++){
		     for(int j=0;j<=userB.size();j++){
		       if(i==0||j==0){
		         lcs[i][j]=0;
		        
		       }
		       else if(userA.get(i-1).equals(userB.get(j-1))){
		         lcs[i][j]=lcs[i-1][j-1]+1;
		         longest=Integer.max(longest,lcs[i][j]);
		         if(longest==lcs[i][j]){
		         lrow=i;
		         lcol=j;}
		         
		       }
		               else{
		                 lcs[i][j]=0;
		               } 
		     }
		               }
		               

	if(longest==0)

	{
		return res;
	}

	while(lcs[lrow][lcol]!=0)
	{
		        res.add(0,userA.get(lrow-1));
		                lrow--;
		                lcol--;
		        
		      }

	return res;
}
}
