import java.util.Stack;
public class CheckRedundantBrackets{

	public static boolean checkRedundantBrackets(String expression) {
		Stack<Character> s = new Stack<>();
		for(int i =0;i<expression.length();i++){
			if(expression.charAt(i)==')'){
				if(s.size()<3) return true;
				int count =0;
				while(s.pop()!='(') count++;
				if(count<3) return true;

			}else s.push(expression.charAt(i));
		}
		return false;
	}

	public static void main(String[] args) {
		String a = "a+(b)+c";
		String b = "((a+b))";
		String c = "";
		String d = "a+b";

		System.out.println(checkRedundantBrackets(a));
		System.out.println(checkRedundantBrackets(b));
		System.out.println(checkRedundantBrackets(c));
		System.out.println(checkRedundantBrackets(d));
		// assert checkRedundantBrackets(a);
		// assert checkRedundantBrackets(b);
		// assert !checkRedundantBrackets(c);
		// assert !checkRedundantBrackets(d);
		
	}
}