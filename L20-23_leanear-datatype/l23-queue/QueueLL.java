// class QueueIsEmptyException extends Exception {
// }

// class Node<T>{
// 	T data;
// 	Node<T> next;
// 	Node(T data){
// 		this.data = data;
// 		next = null;
// 	}
// }

// class QueueLL<T>{
// 	private Node<T> front;
// 	private Node<T> rear;
// 	private int size;

// 	QueueLL(){
// 		this.front = null;
// 		this.rear = null;
// 		this.size = 0;
// 	}
// 	void add(T a){
// 		// enqueue operation at the rear place with time O(1);
// 		if(this.rear==null){
// 			this.rear = new Node<T>(a);
// 			this.front = this.rear;
// 		}else{
// 			this.rear.next = new Node<T>(a);
// 			this.rear = this.rear.next;
// 		}
// 		this.size++;
// 	}
// 	T remove() throws QueueIsEmptyException{
// 		// dequeue the element from front place with time O(1);
// 		// System.out.println(size+" "+front);
// 		if(this.size==0) throw new QueueIsEmptyException();
// 		Node<T> temp = this.front;
// 		this.front = this.front.next;
// 		temp.next = null;
// 		this.size--;
// 		return temp.data;
// 	}
// 	T peek() throws QueueIsEmptyException{
// 		// time O(1)  return the front value;
// 		if(this.size==0) throw new QueueIsEmptyException();
// 		return front.data;
// 	}
// 	boolean isEmpty(){
// 		// time O(1) return true or false as it is empty or not
// 		if(this.size==0) return true;
// 		return false;
// 	}
// 	int size(){
// 		// time O(1) return size of queue
// 		return this.size;
// 	}
// }

	// Following is the structure of the node class for a Singly Linked List

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}


public class QueueLL {
	
	//Define the data members
	private Node frontear, rear;
    private int size;


	public QueueLL() {
		//Implement the Constructor
        this.frontear = null;
        this.rear = null;
        this.size = 0;
	}
	


	/*----------------- Public Functions of Stack -----------------*/


	 public void enqueue(int data) {
    	//Implement the enqueue(element) function
        if(this.rear==null){
            this.rear = new Node(data);
            this.frontear = this.rear;
        }else{
            this.rear.next = new Node(data);
            this.rear = this.rear.next;
            
        }
        this.size++;
    }


    public int dequeue() {
    	//Implement the dequeue() function
        if(this.size ==0) return -1;
        int temp = this.frontear.data;
        if(frontear.next==null){
        	this.rear = null;	
        }
        this.frontear = frontear.next;
        this.size--;
        return temp;
    }
    
    public int front() {
        if(this.size==0) return -1;
    	//Implement the frontear() function
        return this.frontear.data;
    }
    
	public int getSize() { 
		//Implement the getSize() function
        return this.size;
    }


    public boolean isEmpty() { 
    	//Implement the isEmpty() function
        return this.size==0?true:false;
    }
}
