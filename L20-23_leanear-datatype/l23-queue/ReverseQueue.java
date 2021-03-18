import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue{

	public static void reverseQueue(Queue<Integer> input) {
		// time O(n^3) space O(n) bruitforce solution only using the queue data structure;
		Queue<Integer> copyInput = new LinkedList<>();
		Queue<Integer> temp = new LinkedList<>();
		while(!input.isEmpty()) copyInput.add(input.remove());
		while(!copyInput.isEmpty()){
			while(!(copyInput.size()==1)) temp.add(copyInput.remove());
			input.add(copyInput.remove());
			// System.out.println(input.remove());
			while(!temp.isEmpty()) copyInput.add(temp.remove()); 
		}	
	}
	public static void reverseQueue1(Queue<Integer> input) {
		//time O(n) space O(n) but here we are using another data structure.
		Stack<Integer> s = new Stack<>();
		while(!input.isEmpty()) s.add(input.remove());
		while(!s.isEmpty()) input.add(s.pop());	
	}
	public static void reverseQueue2(Queue<Integer> input) {
		//time O(n) space O(n) but here we are using recursion only using Queue.
		if(input.size()<2) return;
		Queue<Integer> s = new LinkedList<>();
		s.add(input.poll());
		reverseQueue2(input);
		input.add(s.poll());	
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.add(13);
		reverseQueue2(q);
		// while(!q.isEmpty()){
		// 	System.out.println(q.poll());
		while(!q.isEmpty()){
			System.out.println(q.remove());
		}
		// }
	}

}