
public class boolean_parenthization_problem {


static int count=0;
// Returns count of all possible parenthesizations that lead to
// result true for a boolean expression with symbols like true
// and false and operators like &, | and ^ filled between symbols
static int countParenth(int symb[], char oper[], int symbolstart,int symbollength,int operstart, int operlength)
{
if(symbolstart>symbollength ){
    return 0;
}
else if(operstart==operlength && symbolstart==symbollength-1 ){
    return symb[symbollength-1];
}



      else  if(oper[operstart]=='|'){
    	  int r=countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength);
        if( (symb[symbolstart]|r)==1){
             if(symbolstart==0 && operstart==0){
            	 count++;
             }
             else  return 1;
           
        }
        if(symbolstart+1<=symbollength-1){
         symb[symbolstart+1]= symb[symbolstart]|symb[symbolstart+1];
        if( countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength)==1){
        	 if(symbolstart==0 && operstart==0){
            	 count++;
             }
        	 else  return 1;
       }
        }
       }
    
      else if(oper[operstart]=='&'){
    	  int r=countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength);
        if( (symb[symbolstart]&r)==1){
        	
        	
        	 if(symbolstart==0 && operstart==0){
            	 count++;
             }
        	 else  return 1;
        }
        if(symbolstart+1<=symbollength-1){
         symb[symbolstart+1]= symb[symbolstart]&symb[symbolstart+1];
        if( countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength)==1){
        	 if(symbolstart==0 && operstart==0){
            	 count++;
             }
        	 else  return 1;
       }
        }
       }
       
       else if(oper[operstart]=='^'){
    	   int r=countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength);
        if( (symb[symbolstart]^r)==1){
        	 if(symbolstart==0 && operstart==0){
            	 count++;
             }
        	 else  return 1;
        }
        if(symbolstart+1<=symbollength-1){
         symb[symbolstart+1]= symb[symbolstart]^symb[symbolstart+1];
        if( countParenth(symb, oper, symbolstart+1,symbollength,operstart+1,operlength)==1){
        	 if(symbolstart==0 && operstart==0){
            	 count++;
             }
        	 else  return 1;
       }
        }
       }
return 0;
}
public static void main(String[] args) {
	if(!visited[row+11][col-1]){
	     if(grid[row+1].charAt(col-1)==grid[row].charAt(col)+1){
	        visited[row+1][col-1]=true;
	          return 1+find(row+1,col-1,grid);
	        visited[row+1][col-1]=false;
	         }
	    }
	    
	    
	     
   
	 int symbols[] = new int[]{ 1,1,0,1 }; 
	 String s="|&^";
	 char operators[] =s.toCharArray();
	 
	
	int n = 4;
int symbolstart=0;
int operstart=0;

	// There are 4 ways
	// ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T))
	System.out.println(countParenth(symbols, operators, symbolstart,n,operstart,n-1));
	System.out.println(count);
}
	
}

// Driver program to test above function


