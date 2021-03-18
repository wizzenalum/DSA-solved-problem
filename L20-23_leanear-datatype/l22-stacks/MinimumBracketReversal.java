import java.util.Stack;
public class MinimumBracketReversal{
	public static int countBracketReversals(String input) {
		
		// }},{{}},{{{{}{}
		if(input.length()<=0) return 0;
		int closedBracesInStart = 0, stack = 0, countReversals=0;
		int i=0;
		while(input.charAt(i)=='}'){   // counting first closed brackets.
			i++;
		}
		countReversals = i%2==0?i/2:(i/2)+1;  // need of the counts.
		input = input.substring(i,input.length());  
		input = i%2==0?input:"{"+input;    // creating new input
		for(i=0; i<input.length();i++){			// chacking second part }},{{}} 
			if(input.charAt(i)=='{') stack++;
			else if(stack!=0 && input.charAt(i)=='}') stack--;
			else if(stack==0 && input.charAt(i)=='}'){
				int temp = countBracketReversals(input.substring(i,input.length()));  // now recurse it for more upcoming length.
				if(temp==-1) return temp;
				else return temp+countReversals;
			}
		}
		if(stack%2==0) return (stack/2)+countReversals;
		return -1;
	}

	// method2 using stack
	public static int countBracketReversals1(String input) {
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i<input.length(); i++){
			// System.out.println("for");
			if(input.charAt(i)=='{'){
				// System.out.println("if "+input.charAt(i));
				stack.push(input.charAt(i));
			}else{
				System.out.println("else  " + input.charAt(i));
				if(stack.size()==0 || stack.peek()!='{') stack.push(input.charAt(i));
				else stack.pop();
			}
		}
		char c1,c2;
		int count =0;
		if(stack.size()%2 == 1) return -1;
		while(!stack.isEmpty()){
			c1 = stack.pop();
			c2 = stack.pop();
			if (c1 == c2) count +=1;
			else count+=2;
		}
		return count;
	}

	public static void main(String[] args) {
		String k = "}}{{}}{{{{}{{}}{";
		System.out.println(countBracketReversals1(k));	
	}
}