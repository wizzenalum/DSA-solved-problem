import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseKElementsOfQueue{
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		// using stack
		if(k<2||input.size()<k) return input;
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new LinkedList<>();

		for(int i=0;i<k;i++){
			s.add(input.remove());
		}
		while(!input.isEmpty()){
			q.add(input.remove());
		}
		for(int i=0;i<k;i++){
			input.add(s.pop());
		}
		while(!q.isEmpty()){
			input.add(q.remove());
		}
		return input;
	}

	public static Queue<Integer> reverseKElements1(Queue<Integer> input, int k) {
		// only using the stack 
		if(input.isEmpty()||k>input.size()) return input;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<k;i++){
			stack.add(input.poll());
		}
		while(!stack.isEmpty()){
			input.add(stack.pop());
		}
		for(int i=0; i<input.size()-k;i++){
			int value = input.poll();
			input.add(value);
		}
		return input;
	}
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.add(13);
		q.add(15);
		reverseKElements1(q,2);
		while(!q.isEmpty()){
			System.out.println(q.remove());
		}
	}
}