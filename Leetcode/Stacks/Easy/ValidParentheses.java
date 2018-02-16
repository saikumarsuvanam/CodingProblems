package Easy;

import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution

/*20. Valid Parentheses 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
public class ValidParentheses {
	//better Solution -check below for another straight forward approach.
	class Solution{
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
	
	}
	
	/*Different approach -straight forward*/
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				st.push(c);
			} else if (st.isEmpty() || !checkOpposite(st.peek(),c)) {
				return false;
			} else {
				st.pop();
			}
		}
		if (st.isEmpty())
			return true;
		else
			return false;

	}

	/*
	 * c1-is from stack and c2 - is from String s if stack top is '[' check
	 * whether string char is ']'
	 */
	static boolean checkOpposite(Character c1, Character c2) {
		if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(isValid("[]"));

	}

}
