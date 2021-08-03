import java.util.Stack;
public class Cafeteria{
	public static void main(String...args){
		// StackArray s = new StackArray();
		// StackLL<Integer> s = new StackLL<>();

		// try{
		// 	// s.pop();
		// 	s.push(10);
		// 	System.out.println(s.top());
		// 	s.push(20);
		// 	System.out.println(s.top());
		// 	s.push(30);	
		// 	System.out.println(s.top());
		// 	System.out.println(s.isEmpty());
		// 	System.out.println(s.size());
		// 	// s.ensuresize(51);
		// 	System.out.println(s.size());
		// }
		// catch(StackEmptyException e) {
		// 	System.out.println("hello i catch atck");
		// } 


		Stack<Integer> s = new Stack<>();
		s.push(10);
		System.out.println(s.peek());
		s.push(20);
		System.out.println(s.peek());
		s.push(30);	
		System.out.println(s.peek());
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		// s.ensuresize(51);
		System.out.println(s.pop()+s.size());
		String str = "heloo";
		System.out.print(str.substring(2,str.length()));
	}
}