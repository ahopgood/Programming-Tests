import java.util.Stack;

// you can also use imports, for example:
// import java.math.*;
class NestingTest {
	
	public static void main (String[] args){
		NestingTest sol = new NestingTest();
		System.out.println(sol.nesting("(((()))))"));
		
	}
	
	//Realised that the easiest way to check for a nested string is to check that every open parenthesis is later closed.
	//Used a stack so we could push every open parenthesis and when we find a close parenthesis we pop the previous open parenthesis.
	//In this way if we end up with an empty list then all open parenthesis are matched and provided no other closed parenthesis are added. 
	public int nesting ( String S ) {
		int nested = 0;
		S = S.trim();
		//account for the empty string
		if (S.length() == 0){
			nested = 1;
		} else {
			Stack<Character> stack = new Stack<Character>();
			int strLen = S.length();
			for (int i = 0; i < strLen; i++){
				if (S.charAt(i)==('(')){
					//push onto the stack
					stack.push('(');
				} else if (S.charAt(i)==(')')){
					//peek to see if there's a ( , if so we pop it
					if (!stack.empty() && stack.peek()=='('){
						stack.pop();
					} else if (stack.empty()){
						return 0;
					}
				}
			}//end for
			//now check if our stack is empty, should be if we have a properly nested string
			if (stack.empty()){
				return 1;
			}
		}//end else
		return nested;
	}
}