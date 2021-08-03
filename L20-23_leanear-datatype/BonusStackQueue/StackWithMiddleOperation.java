class Node {
	int data;
	Node next;
	Node prev;
	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
class Stack {
	//attributes of the class;
	private Node head, middle;
	private int size;

		// constructor;
	Stack() {
		this.head	 = null;
		this.middle  = null;
		this.size 	 = 0;

	}

	public void push(int element) {
		Node node = new Node(element);
		node.prev = this.head;
		if(this.head!=null){
			this.head.next = node;
		}
		this.head = node;
		this.size++;
		if(this.middle == null) this.middle = this.head;
		else if(size%2==1) this.middle = this.middle.next;
	}

	public int pop() {
		// Return 0 if the stack is empty
		if(this.size==0) return 0;
		int p = this.head.data;
		this.head = this.head.prev;
		if(this.size%2==1) this.middle = this.middle.prev;
		this.size--;
		return p;        
	}
	
	public int getmiddle() {
		if(this.size==0) return 0;
		return this.middle.data;        
	}
		
	public int removeMiddle() {
		if(this.size==0) return 0;
		int p = this.middle.data;
		if(this.size==1){
			this.head = null;
			this.middle = null;
		}else{
			this.middle.next.prev = this.middle.prev;
			if(middle.prev!=null) this.middle.prev.next = this.middle.next;
			if(this.size%2==1) this.middle = this.middle.prev;
			else this.middle = this.middle.next;
		}
		this.size--;
		return p;    
	}
		
	public void print() {
		Node temp = this.head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.prev;	
		} 
	}
}
public class StackWithMiddleOperation{
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(30);
		s.push(20);
		s.push(10);
		s.push(1);
		// System.out.println(s.removeMiddle());
		s.print();
		System.out.println();
		System.out.println(s.getmiddle());

		// s.push(0);
		// s.removeMiddle();
		// s.removeMiddle();
		// s.removeMiddle();
		// s.push(30);
		// s.push(20);
		// s.push(10);
		// s.push(30);
		// s.push(20);
		// s.push(10);
		// s.print();
		// System.out.println(s.getmiddle());

	}

  }
