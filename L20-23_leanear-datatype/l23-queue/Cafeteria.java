import java.util.Queue;
import java.util.LinkedList;
public class Cafeteria{
	public static void main(String[] args) throws QueueIsEmptyException{
		// Queue<Integer> queue = new LinkedList<Integer>();
		// ArrayQueue queue = new ArrayQueue();
		// CircularQueue queue = new CircularQueue();
		// QueueLL<Integer> queue = new QueueLL<Integer>();
		// // queue.remove();
		// int[] arr = {7,8,6,3,4,6};
		// for(int a: arr){
		// 	queue.add(a);
		// }
		// System.out.println(queue.peek());
		// System.out.println(queue.size());
		// System.out.println(queue.isEmpty());
		// for(int a: arr){
		// 	// a = queue.remove();
		// 	System.out.println(queue.remove());
		// }
		// System.out.println(queue.isEmpty());

		QueueLL queue = new QueueLL();
		// queue.remove();
		int[] arr = {7,8,6,3,4,6};
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(2);
		queue.front();




		// System.out.println(queue.isEmpty());
		// for(int a: arr){
		// 	queue.enqueue(a);
		// }
		// System.out.println(queue.getSize());
		// for(int a: arr){
		// 	// a = queue.remove();
		// 	System.out.println(queue.dequeue());
		// }
		// System.out.println(queue.isEmpty());
		// System.out.println(queue.front());
	}
}