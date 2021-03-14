import java.util.Stack;
public class MinimumBracketReversal{
	public static int countBracketReversals(String input) {
		Stack<Character> open = new Stack<>();
		Stack<Character> close = new Stack<>();
		for(int i=0; i<input.length();i++){
			if(input.charAt(i)=='{') open.push('{');
			else if(input.charAt(i)=='}') close.push('}');
		}
		int diff = open.size()-close.size()>=0?open.size()-close.size():close.size()-open.size();
		if(diff%2==0) return diff/2;
		else return -1;
	}
	public static void main(String[] args) {
		String k = "{{{{}}{{}";
		System.out.println(countBracketReversals(k));	
	}
}