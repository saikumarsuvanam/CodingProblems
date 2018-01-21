package Strings;

import java.util.Stack;

public class tet {
	void convertPreFixToPostFix(chra[] expr)
	{
	   if(expr.length>=3)
	   {
		   
		   	Stack s=new Stack();
	         boolean operandNotFound=true;
			 Stack stack=new Stack();
			 int i=0;
			 while(i<expr.length)
			 {
				if(expr[i] is operator)
				{
				   stack.push(expr[i]);
				}
				else
				{
				    Print expr[i];
					if(operandNotFound)
					{
						operandNotFound=false;
						print expr[++i];
					}
					Print stack.pop();
				}
			 }
			 
	   }

	}
}
